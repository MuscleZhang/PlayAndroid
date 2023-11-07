package com.zjj.playandroid.ui.knowledge

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zjj.playandroid.R
import com.zjj.playandroid.databinding.FragmentKnowledgeBinding
import com.zjj.playandroid.ui.notifications.KnowledgeViewModel
import com.zjj.playandroid.view.FloatActionWindow

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

        val textView: TextView = binding.textKnowledge
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val btnClick = binding.btnClick
        binding.btnClick.setOnClickListener {
            addToolView()

        }
//        btnClick.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Log.d(TAG, "click")
//                addToolView()
//            }
//        })
        btnClick.text = "clicktext"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addToolView() {
        Log.d(TAG, "add view")
        val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val view = LayoutInflater.from(context).inflate(R.layout.window_float, null)
//        val view = FloatActionWindow(context)
        val layoutParams = WindowManager.LayoutParams().apply {
            width = 100
            height = 100
        }
        windowManager.addView(view, layoutParams)
//        val params = WindowManager.LayoutParams(
//            ViewGroup.LayoutParams.WRAP_CONTENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        )
//        params.width = 100
//        params.height = 100
//            params.type = WindowManager.LayoutParams.T
//            view.layoutParams = params
//        windowManager.addView(view, layoutParams)

    }

}