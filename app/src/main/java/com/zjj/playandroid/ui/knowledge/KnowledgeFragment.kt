package com.zjj.playandroid.ui.knowledge

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zjj.playandroid.R
import com.zjj.playandroid.databinding.FragmentKnowledgeBinding
import com.zjj.playandroid.ui.notifications.KnowledgeViewModel

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

//        val textView: TextView = binding.textKnowledge
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
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

//            val view = FloatActionWindow(requireContext())

        val layoutParams = WindowManager.LayoutParams().apply {
            width = WRAP_CONTENT
            height = WRAP_CONTENT
        }
//        view.setCallback(object : MoveCallback {
//            override fun onMove(x: Int, y: Int, dx: Int, dy: Int) {
//                layoutParams.x = x
//                layoutParams.y = y
//                windowManager.updateViewLayout(view, layoutParams)
//            }
//        })

        windowManager.addView(view, layoutParams)

//        windowManager.updateViewLayout(view, )

//        val contentView = this.window.decorView.findViewById(android.R.id.content) as FrameLayout
//        contentView.addView(FloatView(this))


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