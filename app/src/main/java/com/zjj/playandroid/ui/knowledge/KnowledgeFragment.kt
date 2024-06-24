package com.zjj.playandroid.ui.knowledge

import android.app.AppOpsManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zjj.playandroid.MovieDetailHostActivity
import com.zjj.playandroid.R
import com.zjj.playandroid.databinding.FragmentKnowledgeBinding
import com.zjj.playandroid.service.FloatWindowService
import com.zjj.playandroid.ui.notifications.KnowledgeViewModel
import com.zjj.playandroid.view.FloatActionWindow
import com.zjj.playandroid.view.MoveCallback

class KnowledgeFragment : Fragment() {
    val TAG = "KnowledgeFragment"
    private lateinit var notificationsViewModel: KnowledgeViewModel
    private var _binding: FragmentKnowledgeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(KnowledgeViewModel::class.java)

        _binding = FragmentKnowledgeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val btnClick = binding.btnClick
        binding.btnClick.setOnClickListener {
//            activity?.startService(Intent(activity, FloatWindowService::class.java))
//            addToolView()
//            val intent = Intent(context, MovieDetailHostActivity::class.java)
//            startActivity(intent)




        }
        btnClick.text = "clicktext"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addToolView() {
        if(checkPermission().not()) {
            return;
        }
        Log.d(TAG, "add view")
        val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val view = FloatActionWindow(requireContext())


        val layoutParams = WindowManager.LayoutParams()
        layoutParams.width = WRAP_CONTENT
        layoutParams.height = WRAP_CONTENT
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 0) {
            addToolView()
        }
    }

    val OP_SYSTEM_ALERT_WINDOW = 24
    fun checkPermission(): Boolean {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(context)) {
                true
            } else {
                activity?.startActivityForResult(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:${activity?.packageName}")), 0)
                false
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                val opsManager = context?.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
                val clazz = AppOpsManager::class.java
                try {
                    var method = clazz.getDeclaredMethod("checkOp",
                        Int::class.java, Int::class.java, String::class.java)
                    return AppOpsManager.MODE_ALLOWED == method.invoke(opsManager, OP_SYSTEM_ALERT_WINDOW, android.os.Process.myUid(), context?.packageName)
                } catch (e: Exception) {
                    Log.e(TAG, "checkPermission: %s", e)
                }
            }
            true
        }
    }

}