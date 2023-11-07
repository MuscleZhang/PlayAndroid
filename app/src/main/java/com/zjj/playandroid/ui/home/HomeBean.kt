package com.zjj.playandroid.ui.home

data class Tag(val name: String, val url: String)

class HomeBean(
    val title: String,
    val tags: ArrayList<Tag>,
    val niceDate: String,
    val author: String,
    val shareUser: String
) {
//    var title: String = ""
//    var labels: ArrayList<String> = ArrayList()

}