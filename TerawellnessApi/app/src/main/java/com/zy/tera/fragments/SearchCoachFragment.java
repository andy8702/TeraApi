package com.zy.tera.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.zy.tera.R;
import com.zy.tera.adapter.CourseAdapter;
import com.zy.tera.controller.CoursePresenter;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.CourseResponse;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchCoachFragment extends BaseFragment {

    private EditText editText;
    private Button btnSearch;

    private RecyclerView recyclerView;
    private CourseAdapter resultAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private CoursePresenter courseController;


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

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buildCourseData();
            }
        });

    }

    public void buildCourseData(){
        loadingProgressDialog(R.string.loading);
        courseController = new CoursePresenter(this);
        courseController.getCoursebyCoachName(editText.getText().toString().trim(),
                new ControllerInterface() {
                    @Override
                    public void onResult(Object obj) {
                        dismissLoading();
                        CourseResponse courseResponse = (CourseResponse)obj;
                        buildResultView(courseResponse);
                    }

                    @Override
                    public void onError(String msg) {
                        dismissLoading();
                        showToast(msg);
                    }
                });
    }

    public void buildResultView(CourseResponse courseResponse){
        resultAdapter = new CourseAdapter(courseResponse.data.rows);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(resultAdapter);
    }
}
