package com.zjj.playandroid.ui.home

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayout
import com.zjj.playandroid.R

class HomeAdapter(private val data: MutableList<HomeBean>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.home__rv_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.title.text = data[position].title
        for (label in data[position].tags) {
            val labelView = LayoutInflater.from(context).inflate(R.layout.home_item_label, null)
            labelView.findViewById<TextView>(R.id.tv_label).text = label.name
            holder.labels.addView(labelView)
        }
        holder.author.text =
            if (!TextUtils.isEmpty(data[position].author)) "作者:" + data[position].author else if (TextUtils.isEmpty(
                    data[position].shareUser
                )
            ) "作者:" + data[position].shareUser else ""
        holder.timeView.text = data[position].niceDate
//        holder.typeView.text = data[position].
    }

//  position  private fun buildString(directionality: CharDirectionality, String a1...) {
//
//    }


    override fun getItemCount(): Int {
        return data.size
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.article_title)
        val labels: FlexboxLayout = itemView.findViewById(R.id.label_layout)
        val author: TextView = itemView.findViewById(R.id.article_author)
        val timeView: TextView = itemView.findViewById(R.id.article_time)
        val typeView: TextView = itemView.findViewById(R.id.article_type)

    }
}