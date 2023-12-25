package com.zjj.playandroid.service

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent


/**
 *
 *
 * @author zhangjiajun
 * @since 2023/12/25
 */
class FloatWindowService:AccessibilityService() {
    val TAG = "AccessibilityService"
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d(TAG, "onAccessibilityEvent() called with: event = $event")
    }

    override fun onInterrupt() {
        Log.d(TAG, "onInterrupt() called")
    }
}