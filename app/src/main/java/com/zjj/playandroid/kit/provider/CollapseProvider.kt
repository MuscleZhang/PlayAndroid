package com.zjj.playandroid.kit.provider

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.zjj.playandroid.R


/**
 *
 *
 * @author zhangjiajun
 * @since 2024/2/26
 */
class CollapseProvider(itemView: View, onClickListener: View.OnClickListener) :
    ViewHolder(itemView) {
    val rootView: LinearLayout
    val titleView: TextView
    val iconView: ImageView
    val preBlankView: View

    init {
        rootView = itemView.findViewById(R.id.ll_root)
        titleView = itemView.findViewById(R.id.content)
        iconView = itemView.findViewById(R.id.iv_collapse_status)
        preBlankView = itemView.findViewById(R.id.pre_blank)
//        rootView.setOnClickListener(onClickListener)
    }
}