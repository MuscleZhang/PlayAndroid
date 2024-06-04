package com.zjj.playandroid.utils

import android.widget.Toast
import com.zjj.playandroid.App


/**
 * 计算器相关方法
 *
 * @author zhangjiajun
 * @since 2024/3/14
 */
object Calculator {
    /**
     * 是否是闰年
     */
    fun checkIsLeapYear(year: Int): Boolean {
        if (year <=0) {
            Toast.makeText(App.INSTANCE.applicationContext, "年份不合法", Toast.LENGTH_SHORT).show()
            return false
        }
        if (year % 100 == 0 && year % 400 == 0) {
            Toast.makeText(App.INSTANCE.applicationContext, "$year 是闰年", Toast.LENGTH_SHORT).show()
            return true
        }
        if (year % 4 == 0) {
            Toast.makeText(App.INSTANCE.applicationContext, "$year 是闰年", Toast.LENGTH_SHORT).show()
            return true
        }
        Toast.makeText(App.INSTANCE.applicationContext, "$year 不是闰年", Toast.LENGTH_SHORT).show()
        return false
    }
}