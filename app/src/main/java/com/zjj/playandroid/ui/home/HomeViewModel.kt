package com.zjj.playandroid.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class HomeViewModel : ViewModel() {
    val TAG = "HomeViewModel"

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    val data = MutableLiveData<HomeResponse>()

    fun getData() {
        Log.d(TAG, "getData")
        val url = "https://www.wanandroid.com/article/list/0/json"
        val request = Request.Builder().url(url)
            .get()
            .build()
        OkHttpClient().newCall(request)
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d(TAG, "onFailure %s", e)
                }

                override fun onResponse(call: Call, response: Response) {

                    val json = response.body?.string();
                    Log.d(TAG, "onResponse $json")
                    val fromJson = Gson().fromJson(json, HomeBaseResponse::class.java)
                    data.postValue(fromJson.data)
                }

            })

    }

}

