package com.zy.tera;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.zy.tera.fragments.ShopCourseFragment;

public class ShopCourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_course_detail);

        Bundle bundle = getIntent().getExtras();

        FragmentManager fragmentManager = getSupportFragmentManager();

        ShopCourseFragment  fragment = (ShopCourseFragment) fragmentManager.findFragmentById(R.id.fragment_shopcourse);
        fragment.setArguments(bundle);
        fragment.initData();
    }
}
