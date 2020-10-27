package com.zy.kt.tera.pages

import android.os.Bundle
import com.bumptech.glide.Glide
import com.zy.tera.R
import io.flutter.embedding.android.FlutterActivity
import kotlinx.android.synthetic.main.kt_activity_main.*

class MainActivity:BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kt_activity_main);

        Glide.with(this).load(R.drawable.terawellnesslogo).into(image);

        image.postDelayed(Runnable {
            startActivity(FlutterActivity.createDefaultIntent(this))
            finish()
        },3000)

    }
}