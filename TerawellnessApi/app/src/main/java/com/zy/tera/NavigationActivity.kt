package com.zy.tera

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_navigation.*


class NavigationActivity : BaseActivity() {

//     val coachSearch: Button
//     val shopCourse: Button
//     val myAppointment: Button
//
//     val workCheckinout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        initView()
    }

    private fun initView(){
        val intent = Intent(this,MainActivity::class.java)

        basicinfo.setOnClickListener{
            intent.putExtra("fid",1)
            startActivity(intent)
        }

        onedayonecourse2.setOnClickListener{
            intent.putExtra("fid",2)
            startActivity(intent)
        }

        search_coach_course.setOnClickListener{
            intent.putExtra("fid",3)
            startActivity(intent)
        }

        search_shop.setOnClickListener{
            intent.putExtra("fid",4)
            startActivity(intent)
        }

        my_appointment.setOnClickListener{
            intent.putExtra("fid",5)
            startActivity(intent)
        }

        checkin.setOnClickListener{
            intent.putExtra("fid",6)
            startActivity(intent)
        }


    }
}
