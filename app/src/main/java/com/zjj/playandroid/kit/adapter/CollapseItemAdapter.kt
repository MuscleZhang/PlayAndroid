package com.zjj.playandroid.kit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zjj.playandroid.R
import com.zjj.playandroid.kit.bean.CollapseRvBean
import com.zjj.playandroid.kit.provider.CollapseProvider


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/2/26
 */
class CollapseItemAdapter() :
    RecyclerView.Adapter<CollapseProvider>(),
    View.OnClickListener {
    // 将原树级结构转化为 一级列表
    var collapseData: ArrayList<CollapseRvBean> = ArrayList()

//    private var originalData: List<CollapseRvBean> = ArrayList()
//        set(value) {
//            val list: ArrayList<CollapseRvBean> = ArrayList()
//            initData(value, list)
//            collapseData.clear()
//            collapseData.addAll(list)
//        }

    public fun setData(originalData: List<CollapseRvBean>) {
        val list: ArrayList<CollapseRvBean> = ArrayList()
        initData(originalData, list)
        collapseData.clear()
        collapseData.addAll(list)
    }

    init {
//        val list: ArrayList<CollapseRvBean> = ArrayList()
//        initData(originalData, list)
//        collapseData.clear()
//        collapseData.addAll(list)
    }


    private fun initData(data: List<CollapseRvBean>, newList: ArrayList<CollapseRvBean>) {
        data.forEach {
            newList.add(it)
            // 如果当前节点是展开状态，则将当前节点下的所有子节点全部添加到列表中
            it.childList?.let {
                childList ->
                if (it.isExpanded && childList.isNotEmpty()) {
                    initData(childList, newList)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollapseProvider {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_collapse_rv, parent, false)
        return CollapseProvider(view, this)
    }


    override fun onBindViewHolder(holder: CollapseProvider, position: Int) {
        var bean = collapseData[position]
        holder.titleView.text = bean.name
        holder.preBlankView.layoutParams.width = bean.depth * 32
        holder.iconView.setImageResource(if (bean.isExpanded) R.drawable.ic_collapse else R.drawable.ic_expand)
        holder.rootView.setOnClickListener {
            if (bean.childList?.isNotEmpty() == true) {
                if (bean.isExpanded) {
                    bean.isExpanded = false
                    collapseItem(position, bean)
                } else {
                    bean.isExpanded = true
                    expandItem(position, bean)
                }
                holder.iconView.setImageResource(if (bean.isExpanded) R.drawable.ic_collapse else R.drawable.ic_expand)
            } else {
                holder.iconView.visibility = View.GONE
                bean.onClick?.onClick(it)
            }
        }
    }

    private fun expandItem(position: Int, bean: CollapseRvBean) {
        val listToAdd = ArrayList<CollapseRvBean>()
        addChildToList(collapseData[position], listToAdd)
        collapseData.addAll(position + 1, listToAdd)
        notifyDataSetChanged()
    }

    private fun addChildToList(
        curItem: CollapseRvBean,
        listToAdd: ArrayList<CollapseRvBean>
    ) {
        curItem.childList?.let {
            childList ->

            if (childList.isNotEmpty()) {
                childList.forEach {
                    listToAdd.add(it)
                    if (it.isExpanded && it.childList?.isNotEmpty() == true) {
                        addChildToList(it, listToAdd)
                    }
                }
            }

        }
    }

    private fun collapseItem(position: Int, bean: CollapseRvBean) {
        val curItem = collapseData[position]
        val listToRemove = getListToRemove(curItem)
        collapseData.removeAll(listToRemove)

        notifyDataSetChanged()

    }

    private fun getListToRemove(curItem: CollapseRvBean): ArrayList<CollapseRvBean> {
        val list = ArrayList<CollapseRvBean>()
        curItem.childList?.forEach {
            list.add(it)
            if (it.isExpanded && (it.childList?.isNotEmpty() == true)) {
                list.addAll(getListToRemove(it))
            }
        }
        return list
    }

    override fun getItemCount(): Int {
        return collapseData.size
    }

    override fun onClick(v: View?) {

    }
}