package com.zjj.playandroid.ui.home

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zjj.playandroid.R

class BlackItemDecoration(mContext: Context?) : RecyclerView.ItemDecoration() {
    var mDividerHeight = 1
    private val mPaint: Paint = Paint()

    init {
        if(mContext != null) {
            mPaint.color = mContext.resources.getColor(R.color.divider_black)
        } else {
            mPaint.color = Color.parseColor("#191919")
        }
        mPaint.isAntiAlias = true
    }

    private var mOffsetTop: Int = 0;
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val count = parent.childCount
        for (i in 0 until  count) {
            val item = parent.getChildAt(i)
            val dividerTop = item.top - mDividerHeight
            val dividerBottom = item.top
            val dividerLeft = item.left
            val dividerRight = item.right
            c.drawRect(dividerLeft.toFloat(), dividerTop.toFloat(), dividerRight.toFloat(),
                dividerBottom.toFloat(), mPaint)
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = 1;
            mOffsetTop = 1
        }
    }


}