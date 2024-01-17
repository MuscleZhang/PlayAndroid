package com.zjj.playandroid

import android.app.Application
import com.zjj.playandroid.service.FloatWindowService
import com.zjj.playandroid.utils.PermissionUtil


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/1/13
 */
class App : Application() {
    companion object {
        lateinit var INSTANCE: Application
    }
    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
    }
}