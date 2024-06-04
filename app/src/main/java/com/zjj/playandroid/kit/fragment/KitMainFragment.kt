package com.zjj.playandroid.kit.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import com.zjj.playandroid.R
import com.zjj.playandroid.databinding.DialogEditTextBinding
import com.zjj.playandroid.kit.bean.CollapseRvBean
import com.zjj.playandroid.utils.Calculator
import com.zjj.playandroid.widget.CommonDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KitMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KitMainFragment : BaseCollapseItemRvFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        var view = inflater.inflate(R.layout.fragment_kit_main, container, false)
//        var textView = view.findViewById<TextView>(R.id.tv_view)
//        textView.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_kitMainFragment_to_viewDemoFragment)
//        }
////        textView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_kitMainFragment_to_baseCollapseItemRvFragment))
//        return view
//    }

    override fun getData(): ArrayList<CollapseRvBean> {

        val data = ArrayList<CollapseRvBean>()
        val bean = CollapseRvBean("计算器")
        bean.depth = 1
        val coculatorList = ArrayList<CollapseRvBean>()
        val coculatorBean = CollapseRvBean("检测闰年")

        coculatorBean.depth = 2
        coculatorBean.onClick = View.OnClickListener {
            activity?.let { it1 ->

                var root = DialogEditTextBinding.inflate(layoutInflater).root
                root.inputType = EditorInfo.TYPE_CLASS_NUMBER

                CommonDialog.Builder(it1)
                    .setContentView(root)
                    .setLeftBtnText("确定")
                    .setLeftClickListener {
                        val result = Calculator.checkIsLeapYear(root.text.toString().toInt())

                    }
                    .create().show()

            }

        }
        coculatorList.add(coculatorBean)
        bean.childList = coculatorList
        data.add(bean)

        return data
    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KitMainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KitMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}