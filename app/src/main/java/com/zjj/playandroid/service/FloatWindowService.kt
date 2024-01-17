package com.zjj.playandroid.service

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.zjj.playandroid.utils.BroadcastManager


/**
 * 悬浮窗常驻服务 借助无障碍服务实现
 *
 * @author zhangjiajun
 * @since 2023/12/25
 */
class FloatWindowService:AccessibilityService() {
    val TAG = "AccessibilityService"

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d(TAG, "onServiceConnected() called")
        var intent = Intent(BroadcastManager.ACTION_ACCESSIBILITY_CONNECTED)
        BroadcastManager.sendBroadcast(this, intent)
//        var broadcast =

    }
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d(TAG, "onAccessibilityEvent() called with: event = $event")
    }

    override fun onInterrupt() {
        Log.d(TAG, "onInterrupt() called")
    }
}