package com.zy.kt.tera.pages

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity:FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.kt_activity_main);

//        Glide.with(this).load(R.drawable.terawellnesslogo).into(image);

        GeneratedPluginRegistrant.registerWith(FlutterEngine(this));
        val methodChannel = MethodChannel(flutterEngine?.dartExecutor?.binaryMessenger, "TeraMC")
        methodChannel.setMethodCallHandler { call, result ->
            Log.d("mc","MethodCallHandler,method = "+call.method)
            if (call.method == "single_course") {
                Log.d("mc","single_course")
                Toast.makeText(this, "single_course", Toast.LENGTH_SHORT).show()
            }
            result.success("ok")
        }

//        image.postDelayed(Runnable {
//            startActivity(FlutterActivity.createDefaultIntent(this))
//        }, 3000)



    }
}