package com.zjj.playandroid.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.ViewGroup
import android.view.WindowManager
import com.zjj.playandroid.view.FloatActionWindow
import com.zjj.playandroid.view.MoveCallback


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/1/16
 */
object FlowWindowManager {
    val TAG = "FlowWindowManager"

    fun addToolView(context: Activity) {

        if (PermissionUtil.requestOverlaysPermission(context)) {
            Log.d(TAG, "add view")
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val view = FloatActionWindow(context)


            val layoutParams = WindowManager.LayoutParams()
            layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            layoutParams.flags =  WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE
            }
            view.setCallback(object : MoveCallback {
                override fun onMove(x: Int, y: Int, dx: Int, dy: Int) {
                    Log.d(TAG, "before onMove" + layoutParams.x + "," + layoutParams.y)
                    layoutParams.x += dx
                    layoutParams.y += dy

                    Log.d(TAG, "after onMove" + layoutParams.x + "," + layoutParams.y)
                    windowManager.updateViewLayout(view, layoutParams)
                }
            })

            windowManager.addView(view, layoutParams)
        }

    }
}