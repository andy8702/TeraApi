package com.zy.tera.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import com.zy.tera.R;
import com.zy.tera.adapter.CourseAdapter;
import com.zy.tera.adapter.CourseTypeAdapter;
import com.zy.tera.adapter.TypeCourseAdapter;
import com.zy.tera.controller.CoursePresenter;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.CourseResponse;
import com.zy.tera.response.CourseTypeResponse;
import com.zy.tera.response.TypeCourseResponse;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneCourseFragment extends BaseFragment {

    private RecyclerView typeRv,resultRv;
    private GridView courseGv;
    private CourseTypeAdapter typeAdapter;
    private TypeCourseAdapter courseAdapter;
    private CourseAdapter resultAdapter;

    private CoursePresenter coursePresenter;

    private RecyclerView.LayoutManager mLayoutManager;

    private ImageButton ibShowHide;

    public OneCourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_course, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        typeRv = view.findViewById(R.id.rv_coursetype);
        resultRv = view.findViewById(R.id.rv_result);

        courseGv = view.findViewById(R.id.rv_course);

        ibShowHide = view.findViewById(R.id.ibShowHide);
        ibShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (View.GONE ==courseGv.getVisibility()){
                    courseGv.setVisibility(View.VISIBLE);
                }else{
                    courseGv.setVisibility(View.GONE);
                }
            }
        });

        loadCourseType();
    }

    public void buildTypeView(final List<CourseTypeResponse.CourseTypeInfo.Rows> rows){
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        typeAdapter = new CourseTypeAdapter(rows);
        typeAdapter.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onClick(Object obj) {
                Integer pos = (Integer)obj;
                CourseTypeResponse.CourseTypeInfo.Rows item = rows.get(pos);
                buildTypeDatailView(item);
            }
        });

        typeRv.setLayoutManager(mLayoutManager);
        typeRv.setAdapter(typeAdapter);


    }

    public void buildResultData(TypeCourseResponse.TypeCourseInfo.Rows courseInfo){
        loadingProgressDialog(R.string.loading);
        coursePresenter.getCourseInfobyName(courseInfo.id.toString(), new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                dismissLoading();
                CourseResponse response = (CourseResponse)obj;
                buildResultView(response);
            }

            @Override
            public void onError(String msg) {
                dismissLoading();
                showToast(msg);
                buildResultView(null);
            }
        });
    }

    public void buildResultView(CourseResponse response){
        if (null == response){
            resultRv.setAdapter(null);
            return;
        }

        courseGv.setVisibility(View.GONE);
        resultAdapter = new CourseAdapter(response.data.rows);

        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        resultRv.setLayoutManager(mLayoutManager);
        resultRv.setAdapter(resultAdapter);
    }

    public void buildGridView(List<TypeCourseResponse.TypeCourseInfo.Rows> list){
        courseGv.setVisibility(View.VISIBLE);
        courseAdapter = new TypeCourseAdapter(getContext(),list);
        courseGv.setAdapter(courseAdapter);
        courseGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TypeCourseResponse.TypeCourseInfo.Rows courseInfo = (TypeCourseResponse.TypeCourseInfo.Rows)
                        courseAdapter.getItem(i);
                buildResultData(courseInfo);
            }
        });
    }

    public void buildTypeDatailView(CourseTypeResponse.CourseTypeInfo.Rows item){
        loadingProgressDialog(R.string.loading);
        coursePresenter.getCourseByType(item, new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                dismissLoading();
                TypeCourseResponse response = (TypeCourseResponse)obj;
                buildGridView(response.data.rows);
            }

            @Override
            public void onError(String msg) {
                dismissLoading();
                showToast(msg);
            }
        });
    }


    public void loadCourseType(){
        coursePresenter = new CoursePresenter(this);
        coursePresenter.loadCourseType(new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                CourseTypeResponse courseTypeResponse = (CourseTypeResponse)obj;
                buildTypeView(courseTypeResponse.data.rows);
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }
}
