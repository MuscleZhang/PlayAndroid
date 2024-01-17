package com.zjj.playandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zjj.playandroid.databinding.ActivityMainBinding
import com.zjj.playandroid.utils.BroadcastManager
import com.zjj.playandroid.utils.FlowWindowManager

class MainActivity : AppCompatActivity() {
    val TAG = "AppCompatActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.navigation_knowledge
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val intentFilter = IntentFilter()
        intentFilter.addAction(BroadcastManager.ACTION_ACCESSIBILITY_CONNECTED)
        registerReceiver(MainReceiver(), intentFilter)
        Log.d(TAG, "onCreate")
        // 无障碍方案还是存在部分页面无法显示问题
//        if (PermissionUtil.requestAccessibilityPermission(this, FloatWindowService::class.java)) {
        FlowWindowManager.addToolView(this)
//        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d(
            TAG,
            "onRequestPermissionsResult() called with: requestCode = $requestCode, permissions = $permissions, grantResults = $grantResults"
        )
    }

    inner class MainReceiver : BroadcastReceiver() {
        private val TAG = "MainReceiver"
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d(TAG, "onReceive() called with: context = $context, intent = $intent")
            if (intent != null) {
                when (intent.action) {
                    BroadcastManager.ACTION_ACCESSIBILITY_CONNECTED -> {

                        FlowWindowManager.addToolView(this@MainActivity)
                    }
                    else -> {}
                }
            }
        }

    }

}