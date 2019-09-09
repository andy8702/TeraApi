package com.zy.tera.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zy.tera.R;
import com.zy.tera.TeraApplication;
import com.zy.tera.controller.LoginController;
import com.zy.tera.jetpack.pagedadapter.PagedShopAdapter;
import com.zy.tera.jetpack.pagedadapter.ShopRows;
import com.zy.tera.jetpack.vm.BasicInfoVM;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.LoginResponse;
import com.zy.tera.response.MembershipResponse;
import com.zy.tera.response.ShopResponse;
import com.zy.tera.utils.TimeUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BasicInfoFragment extends BaseFragment {


    private TextView cardNo,name,expire;
    private LoginController loginController;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //JepPack
    private BasicInfoVM basicInfoVM;
    private PagedShopAdapter pagedShopAdapter;

    public BasicInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardNo = view.findViewById(R.id.basic_cardno);
        name = view.findViewById(R.id.basic_name);
        expire = view.findViewById(R.id.basic_expire);

        recyclerView = view.findViewById(R.id.recycler_view);

        basicInfoVM = ViewModelProviders.of(this).get(BasicInfoVM.class);

        buildLoginData();
    }

    public void initRecycleViewData(List<ShopResponse.ShopInfo.Rows> rows){
        pagedShopAdapter = new PagedShopAdapter(ShopRows.DIFF_CALLBACK);


        basicInfoVM.setData(convertData(rows));
        basicInfoVM.getShoprows().observe(this, new Observer<PagedList<ShopRows>>() {
            @Override
            public void onChanged(PagedList<ShopRows> shopRows) {
                pagedShopAdapter.submitList(shopRows);
            }
        });


        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        mAdapter = new SimpleShopAdapter(rows);
        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setAdapter(mAdapter);
        recyclerView.setAdapter(pagedShopAdapter);
    }

    public List<ShopRows> convertData(List<ShopResponse.ShopInfo.Rows> rows){
        if (rows.isEmpty()){
            return null;
        }else{
            List<ShopRows> list = new ArrayList<ShopRows>();
            for (ShopResponse.ShopInfo.Rows row : rows){
                ShopRows item = new ShopRows();
                item.club_id = row.club_id;
                item.club_no = row.club_no;
                item.clubname = row.clubname;

                list.add(item);
            }

            return list;
        }
    }

    public void buildAvailableShop(MembershipResponse response){
        Log.d("login","begin to load available shops");

        loginController.loadAvailableShop(response, new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                ShopResponse shopResponse = (ShopResponse)obj;

                ((TeraApplication)getActivity().getApplication()).setAvailableShopInfo(shopResponse);

                List<ShopResponse.ShopInfo.Rows> rows = shopResponse.data.rows;

                if (!rows.isEmpty()){
                    initRecycleViewData(rows);
                }

                dismissLoading();
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
                dismissLoading();
            }
        });

    }

    public void buildCardData(String userid){
        Log.d("login","begin to load membership");
        loginController.loadMembership(userid, new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                MembershipResponse response = (MembershipResponse) obj;
                if (!response.getValidCardInfo().isEmpty()){
                    for (MembershipResponse.Membership.CardInfo card:response.getData().getRows()) {
                        if (TimeUtils.isValidCard(card.getEnddate())){
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("从"+card.getBegindate());
                            stringBuffer.append("至"+card.getEnddate());

                            replaceSpaceHolder(expire,stringBuffer.toString());

                            ((TeraApplication)getActivity().getApplication()).setMembershipInfo(response);
                            Log.d("login","membership done");

                            buildAvailableShop(response);
                            break;
                        }
                    }
                }

            }

            @Override
            public void onError(String msg) {
                showToast(msg);
                dismissLoading();
            }
        });
    }

    public void buildLoginData(){
        loadingProgressDialog(R.string.loading);
        Log.d("login","begin to login");
        loginController = new LoginController();
        try {
            loginController.loginResponse(new ControllerInterface() {
                @Override
                public void onResult(Object obj) {
                    LoginResponse loginResponse = (LoginResponse)obj;
                    ((TeraApplication)getActivity().getApplication()).setLoginInfo(loginResponse);
                    replaceSpaceHolder(cardNo,loginResponse.getData().getRows().getErp_cardid());
                    replaceSpaceHolder(name,loginResponse.getData().getRows().getErp_username());
                    Log.d("login","login done");
                    buildCardData(loginResponse.getData().getRows().getErp_userid());
                }

                @Override
                public void onError(String msg) {
                    showToast(msg);
                    dismissLoading();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
