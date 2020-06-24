package com.zy.tera

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.zy.tera.db.CoachRateInfo
import com.zy.tera.db.TeraDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_ratesetting_rate.*

class RateSettingActivity: BaseActivity() {

    private lateinit  var coachRateInfo:CoachRateInfo;
    private val disposable = CompositeDisposable();

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

            coachRateInfo.rate = rating;
            Log.d("rating",rating.toString());

            disposable.add(TeraDatabase.getInstance(this).coachRateInfoDao().insertUser(coachRateInfo)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Toast.makeText(this,R.string.oper_success,Toast.LENGTH_SHORT).show();
                        finish();
                    },
                            { error -> Log.e("db", "Unable to insert", error) }))


        }
    }

    override fun onStop() {
        super.onStop()
        disposable.clear();
    }
}