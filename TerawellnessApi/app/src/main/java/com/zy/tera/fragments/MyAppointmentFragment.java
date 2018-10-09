package com.zy.tera.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zy.tera.R;
import com.zy.tera.TeraApplication;
import com.zy.tera.adapter.MyAppointmentAdapter;
import com.zy.tera.controller.BookController;
import com.zy.tera.controller.CoursePresenter;
import com.zy.tera.response.ApmtedCourseResponse;
import com.zy.tera.response.BookResultResponse;
import com.zy.tera.response.ControllerInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAppointmentFragment extends BaseFragment {

    private ListView lsMyapp;

    private CoursePresenter courseController;
    private BookController bookController;

    public MyAppointmentFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_appointment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lsMyapp = view.findViewById(R.id.ls_myapp);
        loadData();
    }

    public void loadData() {
        TeraApplication app = (TeraApplication) (getActivity().getApplication());

        String userid = app.loginResponse.getData().getRows().getId();

        loadingProgressDialog(R.string.loading);

        courseController = new CoursePresenter(this);
        courseController.getAptedCourse(userid, new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                dismissLoading();
                ApmtedCourseResponse response = (ApmtedCourseResponse)obj;
                MyAppointmentAdapter adapter = new MyAppointmentAdapter(getContext(),response.data.groupoplist);
                adapter.setOnClickListener(new MyAppointmentAdapter.OnClickListener() {
                    @Override
                    public void onItemClick(ApmtedCourseResponse.GroupClassInfo.ApmtedInfo item) {
                        cancelCourse(item);
                    }
                });

                lsMyapp.setAdapter(adapter);

            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });

    }

    public void cancelCourse(ApmtedCourseResponse.GroupClassInfo.ApmtedInfo item){
        if (null == bookController){
            bookController = new BookController();
        }

        bookController.cancelBook(item.reservationid, new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                BookResultResponse response = (BookResultResponse) obj;
                showToast(response.p_msg);
                loadData();
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }
}
