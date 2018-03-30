package com.zy.tera;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.zy.tera.fragments.BasicInfoFragment;
import com.zy.tera.fragments.OneCourseFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // 抽屉菜单对象
    public DrawerLayout drawerLayout;
    private RelativeLayout main_left_drawer_layout;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_main2);

        initLayout();
    }

    public void initLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);

        //设置菜单内容之外其他区域的背景色
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        //左边菜单
        main_left_drawer_layout = (RelativeLayout) findViewById(R.id.main_left_drawer_layout);

//        changeFragment(new BasicInfoFragment());

        changeFragment(new OneCourseFragment());
    }

    public void changeFragment(Fragment newFragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //左边菜单开关事件
    public void openLeftLayout(View view) {
        if (drawerLayout.isDrawerOpen(main_left_drawer_layout)) {
            drawerLayout.closeDrawer(main_left_drawer_layout);
        } else {
            drawerLayout.openDrawer(main_left_drawer_layout);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menu_basicinfo:
                changeFragment(new BasicInfoFragment());
                break;

            case R.id.menu_onedayonecourse:
                changeFragment(new OneCourseFragment());
                break;

            default:
        }
    }
}
