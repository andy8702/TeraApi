package com.zy.tera

import android.os.Bundle
import android.util.Log
import com.zy.tera.db.CoachRateInfo
import kotlinx.android.synthetic.main.activity_ratesetting_rate.*

class RateSettingActivity: BaseActivity() {

    private lateinit  var coachRateInfo:CoachRateInfo;


    companion object{
       const val FLAG_isRating:String = "isRate";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coachRateInfo = intent.getParcelableExtra<CoachRateInfo>(FLAG_isRating);

        if (null == coachRateInfo){
            //设置页面
            setContentView(R.layout.activity_ratesetting_setting);
        }else{
            //打分页面
            setContentView(R.layout.activity_ratesetting_rate);

            initRatingView();

        }


    }

    fun initRatingView(){
        coachname.setText(coachRateInfo?.name+"("+coachRateInfo?.id+")");

        ratingbar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

            Log.d("rating",rating.toString());

        }
    }
}