package com.zjj.playandroid.utils

import android.app.AppOpsManager
import android.content.Context
import android.os.Build
import android.provider.Settings


/**
 *
 *
 * @author zhangjiajun
 * @since 2023/10/19
 */
object PermissionUtil {
    public fun canDrawOverLays(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Settings.canDrawOverlays(context)
        } else {
            var appOpsManager = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
//            var clazz = AppOpsManager.class.java.getDeclaredMethod("check")

            false

        }
    }
}