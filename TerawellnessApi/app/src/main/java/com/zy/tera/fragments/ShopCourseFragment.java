package com.zy.tera.fragments;


import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import com.zy.tera.R;
import com.zy.tera.TeraApplication;
import com.zy.tera.adapter.ShopCourseAdapter;
import com.zy.tera.controller.BookController;
import com.zy.tera.controller.CourseController;
import com.zy.tera.response.BookResultResponse;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.CourseDetailResponse;
import com.zy.tera.utils.TimeUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCourseFragment extends BaseFragment {


    public static String KEY_CLUBID = "clubid";

    private Button btnChooser;
    private ListView listView;

    private String clubId;

    private CourseController courseController;
    private BookController bookController;

    public ShopCourseFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop_course, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        clubId = getArguments().getString(KEY_CLUBID);

        btnChooser = view.findViewById(R.id.btn_choose_date);
        listView = view.findViewById(R.id.ls_courese);

        btnChooser.setText(TimeUtils.getTodayDate());
        btnChooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] date = TimeUtils.getYYYYMMDD();

                DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String date = TimeUtils.formateYYYYMMDD(i, i1, i2);
                        btnChooser.setText(date);
                        loadCourseData(date);
                    }
                }, date[0], date[1], date[2]);

                dialog.show();
            }
        });

        if (!TextUtils.isEmpty(clubId)) {
            loadCourseData(null);
        }

    }

    public void loadCourseData(String date) {
        loadingProgressDialog(R.string.loading);
        courseController = new CourseController();
        courseController.getCoursebyShop(clubId, date, new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                dismissLoading();
                CourseDetailResponse response = (CourseDetailResponse) obj;
                buildResultView(response);
            }

            @Override
            public void onError(String msg) {
                dismissLoading();
                showToast(msg);
            }
        });
    }

    public void buildResultView(CourseDetailResponse response) {
        ShopCourseAdapter adapter = new ShopCourseAdapter(getContext(), response.data);

        adapter.setOnClickListener(new ShopCourseAdapter.OnClickListener() {
            @Override
            public void onItemClick(CourseDetailResponse.CourseDetailInfo item) {
                if (null == bookController) {
                    bookController = new BookController();
                }

                TeraApplication app = (TeraApplication) (getActivity().getApplication());

                String userid = app.loginResponse.getData().getRows().getId();
                String mobile = app.loginResponse.getData().getRows().getTelephone();
                String membercode = app.loginResponse.getData().getRows().getErp_userid();


                loadingProgressDialog(R.string.loading);

                //courseid, userid, mobile,membercode
                if (TeraApplication.isUseSpecialBook) {
                    bookController.bookCourese(item.id, userid, mobile, membercode, new ControllerInterface() {
                        @Override
                        public void onResult(Object obj) {
                            dismissLoading();
                            BookResultResponse res = (BookResultResponse) obj;

                            showAlertDialog(res.p_msg);
                        }

                        @Override
                        public void onError(String msg) {
                            dismissLoading();
                            showToast(msg);
                        }
                    });
                } else {
                    bookController.makeAppointment(item.id, userid, mobile, membercode, new ControllerInterface() {
                        @Override
                        public void onResult(Object obj) {
                            dismissLoading();
                            BookResultResponse res = (BookResultResponse) obj;

                            showAlertDialog(res.p_msg);
                        }

                        @Override
                        public void onError(String msg) {
                            dismissLoading();
                            showToast(msg);
                        }
                    });
                }
            }
        });

        listView.setAdapter(adapter);
    }
}
