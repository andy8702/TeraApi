package com.zy.tera

import android.os.Bundle
import android.text.TextUtils
import com.zy.tera.db.CoachRateInfo

class RateSettingActivity: BaseActivity() {

    var coachRateInfo:CoachRateInfo? = null;

    companion object{
       const val FLAG_isRating:String = "isRate";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val from = intent.getStringExtra(FLAG_isRating);

        if (TextUtils.isEmpty(from)){
            setContentView(R.layout.activity_ratesetting_setting);
        }else{
            coachRateInfo = intent.getParcelableExtra(FLAG_isRating);
            setContentView(R.layout.activity_ratesetting_rate);
        }


    }
}