package com.zjj.playandroid.kit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zjj.playandroid.R
import com.zjj.playandroid.kit.adapter.CollapseItemAdapter
import com.zjj.playandroid.kit.bean.CollapseRvBean


/**
 * 知识点 通用可展开列表
 *
 * @author zhangjiajun
 * @since 2024/2/26
 */
open class BaseCollapseItemRvFragment : Fragment() {
    private lateinit var mRecyclerView: RecyclerView
    val adapter = CollapseItemAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_collapse_items_rv, container, false)
        mRecyclerView = view.findViewById(R.id.recycler_view)
        val data = ArrayList<CollapseRvBean>()

//        obtainCollapseRvBean("test1", 3, false, 3, 1)?.let { data.add(it) }
//        obtainCollapseRvBean("test2", 3, true, 2, 1)?.let { data.add(it) }
//        obtainCollapseRvBean("test3", 3, false, 2, 1)?.let { data.add(it) }

        mRecyclerView.adapter = adapter
        return view
    }

    override fun onResume() {
        super.onResume()
        val a = 1
        adapter.setData(getData())
    }

    protected open fun getData():ArrayList<CollapseRvBean>{
        return ArrayList<CollapseRvBean>()
    }



    protected open fun obtainCollapseRvBean(
        name: String,
        childCount: Int,
        isExpanded: Boolean, deep: Int, depth: Int
    ): CollapseRvBean? {
        if (deep <= 0) {
            return null
        }
        val childList = ArrayList<CollapseRvBean>()
        for (i in 1..childCount) {
            obtainCollapseRvBean("$name - $i", 3, true, deep - 1, depth + 1)?.let {
                childList.add(it)
            }
        }
        return CollapseRvBean(name, depth, isExpanded, View.OnClickListener {
            Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
        }, childList)

    }
}