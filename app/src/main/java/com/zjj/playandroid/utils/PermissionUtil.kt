package com.zjj.playandroid.utils

import android.accessibilityservice.AccessibilityService
import android.app.Activity
import android.app.AppOpsManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.text.TextUtils.SimpleStringSplitter
import android.util.Log
import android.widget.Toast
import com.zjj.playandroid.App


/**
 *
 *
 * @author zhangjiajun
 * @since 2023/10/19
 */
object PermissionUtil {
    private const val TAG = "PermissionUtil"
    public fun canDrawOverLays(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Settings.canDrawOverlays(context)
        } else {
            var appOpsManager = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
//            var clazz = AppOpsManager.class.java.getDeclaredMethod("check")

            false

        }
    }

    fun checkAccessibilityPermission(clazz: Class<out AccessibilityService?>): Boolean {
        var accessibilityEnabled = false;
        accessibilityEnabled = Settings.Secure.getInt(
            App.INSTANCE.applicationContext.contentResolver,
            Settings.Secure.ACCESSIBILITY_ENABLED
        ) == 1
        Log.d(
            TAG,
            "checkAccessibilityPermission() called accessibilityEnabled:" + accessibilityEnabled
        )

        var stringSplitter = SimpleStringSplitter(':')
        if (accessibilityEnabled) {
            val settingsService = Settings.Secure.getString(
                App.INSTANCE.applicationContext.contentResolver,
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
            )
            Log.d(TAG, "accessibilityEnabled" + settingsService)
            if (TextUtils.isEmpty(settingsService).not()) {
                stringSplitter.setString(settingsService)
                while (stringSplitter.hasNext()) {
                    val next = stringSplitter.next()
                    if (TextUtils.equals(
                            next,
                            "${App.INSTANCE.applicationContext.packageName}/${clazz.canonicalName}"
                        )
                    ) {
                        return true
                    }
                }
            }
        }
        return false

    }

    /**
     * 请求无障碍权限
     */
    fun requestAccessibilityPermission(context: Activity, clazz: Class<out AccessibilityService?>): Boolean {

        Log.d(TAG, "requestAccessibilityPermission")
        if (checkAccessibilityPermission(clazz)) {

            Log.d(TAG, "requestAccessibilityPermission granted")
            return true
        }
        var intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivityForResult(intent, 0)

        Log.d(TAG, "requestAccessibilityPermission not permissioned")
        return false
    }


    val OP_SYSTEM_ALERT_WINDOW = 24
    fun requestOverlaysPermission(
        context: Activity
    ) : Boolean{
        if (checkPermission(context).not()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.startActivityForResult(
                    Intent(
                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:${context.packageName}")
                    ), 0
                )
                return false
            }

            Toast.makeText(context, "无悬浮窗权限", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false

    }

    fun checkPermission(context: Activity): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(context)) {
                true
            } else {
                context.startActivityForResult(
                    Intent(
                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:${context.packageName}")
                    ), 0
                )
                false
            }
        } else {
            val opsManager = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
            val clazz = AppOpsManager::class.java
            try {
                var method = clazz.getDeclaredMethod(
                    "checkOp",
                    Int::class.java, Int::class.java, String::class.java
                )
                return AppOpsManager.MODE_ALLOWED == method.invoke(
                    opsManager,
                    OP_SYSTEM_ALERT_WINDOW,
                    android.os.Process.myUid(),
                    context?.packageName
                )
            } catch (e: Exception) {
                Log.e(TAG, "checkPermission: %s", e)
            }
            true
        }
    }
}