package com.zy.tera.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zy.tera.R;
import com.zy.tera.RateSettingActivity;
import com.zy.tera.adapter.CourseAdapter;
import com.zy.tera.controller.CoursePresenter;
import com.zy.tera.db.CoachRateInfo;
import com.zy.tera.response.CoachResponse;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.CourseResponse;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchCoachFragment extends BaseFragment {

    private EditText editText;
    private Button btnSearch,btnRate,btnRateSetting;

    private RecyclerView recyclerView;
    private CourseAdapter resultAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private CoursePresenter courseController;

    private CoachRateInfo coachRateInfo;


    public SearchCoachFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_coach, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSearch = view.findViewById(R.id.btn_search);
        recyclerView = view.findViewById(R.id.rv_coachcourse);
        editText = view.findViewById(R.id.search_input);
        btnRate = view.findViewById(R.id.btn_rate);
        btnRateSetting = view.findViewById(R.id.btn_rate_setting);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard(getActivity());
                buildCourseData();
            }
        });

        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=coachRateInfo){
                    Intent intent = new Intent(getActivity(), RateSettingActivity.class);
                    intent.putExtra(RateSettingActivity.FLAG_isRating,coachRateInfo);
                    startActivity(intent);

                }else{
                    Toast.makeText(getContext(),R.string.error_no_coachinfo,Toast.LENGTH_LONG);
                }
            }
        });

        btnRateSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=coachRateInfo){
                    Intent intent = new Intent(getActivity(), RateSettingActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getContext(),R.string.error_no_coachinfo,Toast.LENGTH_LONG);
                }
            }
        });

    }

    public void buildCourseData() {
        loadingProgressDialog(R.string.loading);
        courseController = new CoursePresenter(this);
        courseController.getCoursebyCoachName(editText.getText().toString().trim(),
                new ControllerInterface() {
                    @Override
                    public void onResult(Object obj) {
                        dismissLoading();

                        List<CoachResponse.CoachInfo.Rows> rows = (List<CoachResponse.CoachInfo.Rows>) obj;
                        if (rows.size() == 1) {
                            courseController.getCoursebyCoachId(rows.get(0).id.toString(), new ControllerInterface() {
                                @Override
                                public void onResult(Object obj) {
                                    CourseResponse courseResponse = (CourseResponse) obj;
                                    buildResultView(courseResponse);
                                }

                                @Override
                                public void onError(String msg) {
                                    showToast(msg);
                                }
                            });
                        } else {
                            String[] names = new String[rows.size()];
                            for (int i=0;i<rows.size();i++){
                                names[i] = rows.get(i).name;
                            }

                            AlertDialog.Builder listDialog = new AlertDialog.Builder(getActivity());
                            listDialog.setTitle(R.string.choose);
                            listDialog.setItems(names, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    courseController.getCoursebyCoachId(rows.get(which).id.toString(), new ControllerInterface() {
                                        @Override
                                        public void onResult(Object obj) {
                                            CourseResponse courseResponse = (CourseResponse) obj;
                                            buildResultView(courseResponse);
                                        }

                                        @Override
                                        public void onError(String msg) {
                                            showToast(msg);
                                        }
                                    });

                                }
                            });
                            listDialog.create().show();
                        }
                    }

                    @Override
                    public void onError(String msg) {
                        dismissLoading();
                        showToast(msg);
                    }
                });
    }

    public void buildResultView(CourseResponse courseResponse) {
        if (null!=courseResponse.data.rows && courseResponse.data.rows.size()>0){
            CourseResponse.CourseInfo.Rows row = courseResponse.data.rows.get(0);
            coachRateInfo = new CoachRateInfo(String.valueOf(row.coachid),courseResponse.data.rows.get(0).coachname);
        }

        resultAdapter = new CourseAdapter(courseResponse.data.rows);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(resultAdapter);
    }
}
