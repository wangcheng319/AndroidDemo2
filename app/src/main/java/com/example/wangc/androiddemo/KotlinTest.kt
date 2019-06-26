package com.example.wangc.androiddemo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import org.json.JSONObject

/**
 * Created by wangc on 2018/7/4
 * E-MAIL:274281610@QQ.COM
 */
class KotlinTest : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("","")
        val jsonObject = JSONObject()
        val name =  jsonObject.get("name")
        Log.e("+++", name.toString())
    }

    override fun onRestart() {
        super.onRestart()
    }

}