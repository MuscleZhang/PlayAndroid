package com.zjj.playandroid.utils

import android.content.Context
import android.content.Intent
import android.util.Log


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/1/17
 */
object BroadcastManager {
    val ACTION_ACCESSIBILITY_CONNECTED = "action_accessibility_connected"

     fun sendBroadcast(context: Context, intent: Intent) {
        Log.d("BroadcastManager", "sendBroadcast() called")
        context.sendBroadcast(intent)
    }
}