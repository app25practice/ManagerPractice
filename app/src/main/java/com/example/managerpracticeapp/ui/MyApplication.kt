package com.example.managerpracticeapp.ui

import android.app.Application
import android.util.Log
import com.kakao.vectormap.KakaoMapSdk
import com.example.managerpracticeapp.BuildConfig

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKakaoMapSdk()
    }

    private fun initializeKakaoMapSdk(){
        KakaoMapSdk.init(this, BuildConfig.KAKAO_API_KEY)
    }
}