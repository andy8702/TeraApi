package com.zy.tera;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.zy.tera.fragments.BasicInfoFragment;
import com.zy.tera.fragments.FragmentListener;
import com.zy.tera.fragments.MyAppointmentFragment;
import com.zy.tera.fragments.OneCourseFragment;
import com.zy.tera.fragments.SearchCoachFragment;
import com.zy.tera.fragments.ShopCourseFragment;
import com.zy.tera.fragments.ShopSearchFragment;
import com.zy.tera.fragments.WorkFragment;
import com.zy.tera.response.ShopDetailsResponse;

public class MainActivity extends BaseActivity implements View.OnClickListener,FragmentListener {

    public static int COMMOND_SHOP_COURSES = 1;

    // 抽屉菜单对象
    public DrawerLayout drawerLayout;
    private RelativeLayout main_left_drawer_layout;
    private Button btnBasicInfo, btnOneDayCourse, btnSearchCoach,btnShopSearch,btnMyAptmnt,
    btnWork;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_main2);

        initLayout();

        int v = getIntent().getIntExtra("fid",0);
        loadFragment(v);

    }

    public void initLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        main_left_drawer_layout = (RelativeLayout) findViewById(R.id.main_left_drawer_layout);

        btnWork = findViewById(R.id.menu_work);
        btnWork.setOnClickListener(this);
        btnBasicInfo = findViewById(R.id.menu_basicinfo);
        btnBasicInfo.setOnClickListener(this);
        btnOneDayCourse = findViewById(R.id.menu_onedayonecourse);
        btnOneDayCourse.setOnClickListener(this);
        btnSearchCoach = findViewById(R.id.menu_search_coach_course);
        btnSearchCoach.setOnClickListener(this);
        btnShopSearch =  findViewById(R.id.menu_search_shop);
        btnShopSearch.setOnClickListener(this);
        btnMyAptmnt =  findViewById(R.id.menu_myappointment);
        btnMyAptmnt.setOnClickListener(this);

    }

    private void loadFragment(int value){
        switch (value){
            case 1:
                btnBasicInfo.performClick();
                break;

            case 2:
                btnOneDayCourse.performClick();
                break;

            case 3:
                btnSearchCoach.performClick();
                break;

            case 4:
                btnShopSearch.performClick();
                break;

            case 5:
                btnMyAptmnt.performClick();
                break;

            case 6:
                btnWork.performClick();
                break;

            default:
                btnSearchCoach.performClick();
        }
    }

    public void changeFragment(Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void addFragment(Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.mainFragment, newFragment);
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
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {
        drawerLayout.closeDrawers();

        switch (view.getId()) {
            case R.id.menu_work:
                changeFragment(new WorkFragment());
                break;

            case R.id.menu_basicinfo:
                changeFragment(new BasicInfoFragment());
                break;

            case R.id.menu_onedayonecourse:
                changeFragment(new OneCourseFragment());
                break;

            case R.id.menu_search_coach_course:
                changeFragment(new SearchCoachFragment());
                break;

            case R.id.menu_search_shop:
                ShopSearchFragment fragment = new ShopSearchFragment();
                fragment.setFragmentListener(this);
                changeFragment(fragment);
                break;

            case R.id.menu_myappointment:
                changeFragment(new MyAppointmentFragment());
                break;

            default:
        }
    }


    @Override
    public void onReceive(int commond, Object obj) {
        if (COMMOND_SHOP_COURSES == commond){
            ShopDetailsResponse.ShopDetailInfo.Rows item = (ShopDetailsResponse.ShopDetailInfo.Rows)obj;

            Bundle bundle = new Bundle();
            bundle.putString(ShopCourseFragment.KEY_CLUBID,item.id);

            ShopCourseFragment fragment = new ShopCourseFragment();
            fragment.setArguments(bundle);

            addFragment(fragment);
        }
    }
}
