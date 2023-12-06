package com.zjj.playandroid.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.FrameLayout
import com.zjj.playandroid.LogUtils
import com.zjj.playandroid.R


/**
 * 悬浮功能按钮
 *
 * @author zhangjiajun
 * @since 2023/11/1
 */
class FloatActionWindow : FrameLayout {


    val TAG = "FloatWindow"

    constructor(context: Context) : this(context, null) {
    }


    constructor(context: Context, attrs: AttributeSet?) : this(context, null, 0) {

    }

    constructor(context: Context, attrs: AttributeSet?, def: Int) : super(context, attrs, def) {
        init(context)
    }

    private fun init(context: Context?) {
        val lp = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
////        lp.topMargin = mToolBarHeight
        layoutParams = lp
        LayoutInflater.from(context).inflate(R.layout.window_float, this)

//        addView(childView)

    }

    var mActionX = 0
    var mActionY = 0

    override fun onTouchEvent(event: MotionEvent?): Boolean {


        if (event != null) {
            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    Log.d(TAG, "ACTION_DOWN" + event.rawX)
                    mActionX = event.rawX.toInt()
                    mActionY = event.rawY.toInt()

                }
                MotionEvent.ACTION_MOVE -> {
                    Log.d(TAG, "ACTION_MOVE" + event.rawX + "," + mActionX)
                    val dx = (event.rawX - mActionX).toInt()
                    val dy = (event.rawY - mActionY).toInt()
                    offsetTopAndBottom(dy)
                    offsetLeftAndRight(dx)
                    mActionX = event.rawX.toInt()
                    mActionY = event.rawY.toInt()
                    mCallback?.onMove(mActionX, mActionY, dx, dy)


                }
                MotionEvent.ACTION_UP -> {
                    Log.d(TAG, "ACTION_UP")

                }
            }
        }

        return true
    }

    private var mCallback: MoveCallback? = null

    public fun setCallback(callback: MoveCallback) {
        mCallback = callback
    }


}


interface MoveCallback {
    fun onMove(x: Int, y: Int, dx: Int, dy: Int)
}

private var mViewWidth = 0
private var mViewHeight = 0
////    private var mToolBarHeight = dp2px(56F) // toolbar默认高度
//    private var mDragDistance = 0.5 // 默认吸边需要的拖拽距离为屏幕的一半
//
//    companion object {
//        var ADSORB_VERTICAL = 1001
//        var ADSORB_HORIZONTAL = 1002
////    }
//
//    constructor(context: Context) : this(context, null)
//
//    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
//
//    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(context, attributeSet, defStyle) {
//        initView()
//    }
//
//    private fun initView() {
//        val lp = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
////        lp.topMargin = mToolBarHeight
//        layoutParams = lp
//
//        val childView = LayoutInflater.from(context).inflate(R.layout.window_float, null)
//        addView(childView)
////        setOnTouchListener(this)
//
//        post {
//            // 获取一下view宽高，方便后面计算，省的bottom-top麻烦
//            mViewWidth = this.width
//            mViewHeight = this.height
//        }
//    }
//
//    /**
//     * 获取子view
//     */
//    protected abstract fun getChildView(): View
//
//    /**
//     * 是否可以拖拽
//     */
//    protected abstract fun getIsCanDrag(): Boolean
//
//    /**
//     * 吸边的方式
//     */
//    protected abstract fun getAdsorbType(): Int
//
//    /**
//     * 点击事件
//     */
//    protected var mOnFloatClickListener: OnFloatClickListener? = null
//
//    interface OnFloatClickListener {
//        fun onClick(view: View)
//    }
//
//    fun setOnFloatClickListener(listener: OnFloatClickListener) {
//        mOnFloatClickListener = listener
//    }
//
//    /**
//     * 设置吸边需要的拖拽距离，默认半屏修改吸边方向，取值0-1
//     */
//    fun setDragDistance(distance: Double) {
//        mDragDistance = distance
//    }

//    private var mDownX = 0F
//    private var mDownY = 0F
//    private var mFirstY: Int = 0
//    private var mFirstX: Int = 0
//    private var isMove = false
//
//    override fun onTouch(v: View, event: MotionEvent): Boolean {
//        val x = event.x
//        val y = event.y
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> {
//                mDownX = event.x
//                mDownY = event.y
//                // 记录第一次在屏幕上坐标，用于计算初始位置
//                mFirstY = event.rawY.roundToInt()
//                mFirstX = event.rawX.roundToInt()
//            }
//            MotionEvent.ACTION_MOVE -> {
//                isMove = true
//                offsetTopAndBottom((y - mDownY).toInt())
//                offsetLeftAndRight((x - mDownX).toInt())
//            }
//            MotionEvent.ACTION_UP -> {
//                if (isMove) {
////                    if (getAdsorbType() == ADSORB_VERTICAL) {
////                        adsorbTopAndBottom(event)
////                    } else if (getAdsorbType() == ADSORB_HORIZONTAL) {
////                        adsorbLeftAndRight(event)
////                    }
//                } else {
////                    mOnFloatClickListener?.onClick(v)
//                }
//                isMove = false
//            }
//        }
//        return true
//    }
//
//    /**
//     * 上下吸边
//     */
//    private fun adsorbTopAndBottom(event: MotionEvent) {
//        /**
//         * 1.判断滑动距离是否超过半屏
//         * 2.判断起始位置在上/下半屏
//         * 3.上半屏：
//         *      3.1.滑动距离<半屏=吸顶
//         *      3.2.滑动距离>半屏=吸底
//         * 4.下半屏：
//         *      4.1.滑动距离<半屏=吸底
//         *      4.2.滑动距离>半屏=吸顶
//         */
//        if (isOriginalFromTop()) {
//            // 上半屏
//            val centerY = mViewHeight / 2 + abs(event.rawY - mFirstY)
//            if (centerY < getAdsorbHeight()) {
//                //滑动距离<半屏=吸顶
//                val topY = 0f + mToolBarHeight
//                animate().setInterpolator(DecelerateInterpolator()).setDuration(300).y(topY).start()
//            } else {
//                //滑动距离>半屏=吸底
//                val bottomY = getContentHeight() - mViewHeight
//                animate().setInterpolator(DecelerateInterpolator()).setDuration(300).y(bottomY.toFloat()).start()
//            }
//        } else {
//            // 下半屏
//            val centerY = mViewHeight / 2 + abs(event.rawY - mFirstY)
//            if (centerY < getAdsorbHeight()) {
//                //滑动距离<半屏=吸底
//                val bottomY = getContentHeight() - mViewHeight
//                animate().setInterpolator(DecelerateInterpolator()).setDuration(300).y(bottomY.toFloat()).start()
//            } else {
//                //滑动距离>半屏=吸顶
//                val topY = 0f + mToolBarHeight
//                animate().setInterpolator(DecelerateInterpolator()).setDuration(300).y(topY).start()
//            }
//        }
//        resetHorizontal(event)
//    }
//
//    /**
//     * 上下拖拽时，如果横向拖拽也超出屏幕，则上下吸边时左右也吸边
//     */
//    private fun resetHorizontal(event: MotionEvent) {
//        if (event.rawX < mViewWidth) {
//            animate().setInterpolator(DecelerateInterpolator()).setDuration(300).x(0F).start()
//        } else if (event.rawX > getScreenWidth() - mViewWidth) {
//            animate().setInterpolator(DecelerateInterpolator()).setDuration(300).x(getScreenWidth().toFloat() - mViewWidth).start()
//        }
//    }
//
//    /**
//     * 左右吸边
//     */
//    private fun adsorbLeftAndRight(event: MotionEvent) {
//        /**
//         * 1.判断滑动距离是否超过半屏
//         * 2.判断起始位置在左/右半屏
//         * 3.左半屏：
//         *      3.1.滑动距离<半屏=吸左
//         *      3.2.滑动距离>半屏=吸右
//         * 4.右半屏：
//         *      4.1.滑动距离<半屏=吸右
//         *      4.2.滑动距离>半屏=吸左
//         */
//        if (isOriginalFromLeft()) {
//            // 左半屏
//            val centerX = mViewWidth / 2 + abs(event.rawX - mFirstX)
//            if (centerX < getAdsorbWidth()) {
//                //滑动距离<半屏=吸左
//                val leftX = 0f
//                animate().setInterpolator(DecelerateInterpolator()).setDuration(300).x(leftX).start()
//            } else {
//                //滑动距离<半屏=吸右
//                val rightX = getScreenWidth() - mViewWidth
//                animate().setInterpolator(DecelerateInterpolator()).setDuration(300).x(rightX.toFloat()).start()
//            }
//        } else {
//            // 右半屏
//            val centerX = mViewWidth / 2 + abs(event.rawX - mFirstX)
//            if (centerX < getAdsorbWidth()) {
//                //滑动距离<半屏=吸右
//                val rightX = getScreenWidth() - mViewWidth
//                animate().setInterpolator(DecelerateInterpolator()).setDuration(300).x(rightX.toFloat()).start()
//            } else {
//                //滑动距离<半屏=吸左
//                val leftX = 0f
//                animate().setInterpolator(DecelerateInterpolator()).setDuration(300).x(leftX).start()
//            }
//        }
//        resetVertical(event)
//    }
//
//    /**
//     * 左右拖拽时，如果纵向拖拽也超出屏幕，则左右吸边时上下也吸边
//     */
//    private fun resetVertical(event: MotionEvent) {
//        if (event.rawY < mViewHeight) {
//            animate().setInterpolator(DecelerateInterpolator()).setDuration(300).y(0F + mToolBarHeight).start()
//        } else if (event.rawY > getContentHeight() - mViewHeight) {
//            animate().setInterpolator(DecelerateInterpolator()).setDuration(300).y(getContentHeight().toFloat() - mViewHeight).start()
//        }
//    }
//
//    /**
//     * 初始位置是否在顶部
//     */
//    private fun isOriginalFromTop(): Boolean {
//        return mFirstY < getScreenHeight() / 2
//    }
//
//    /**
//     * 初始位置是否在左边
//     */
//    private fun isOriginalFromLeft(): Boolean {
//        return mFirstX < getScreenWidth() / 2
//    }
//
//    /**
//     * 获取上下吸边时需要拖拽的距离
//     */
//    private fun getAdsorbHeight(): Double {
//        return getScreenHeight() * mDragDistance
//    }
//
//    /**
//     * 获取左右吸边时需要拖拽的距离
//     */
//    private fun getAdsorbWidth(): Double {
//        return getScreenWidth() * mDragDistance
//    }
//
//    /**
//     * dp2px
//     */
//    private fun dp2px(dp: Float): Int {
//        val density = context.resources.displayMetrics.density
//        return (dp * density).toInt()
//    }
//
//    /**
//     * 获取屏幕高度
//     */
//    private fun getScreenHeight(): Int {
//        val dm = DisplayMetrics()
//        (context as? Activity)?.windowManager?.defaultDisplay?.getMetrics(dm)
//        return dm.heightPixels
//    }
//
//    /**
//     * 获取屏幕宽度
//     */
//    private fun getScreenWidth(): Int {
//        val dm = DisplayMetrics()
//        (context as? Activity)?.windowManager?.defaultDisplay?.getMetrics(dm)
//        return dm.widthPixels
//    }
//
//    /**
//     * 获取页面内容区高度
//     */
//    private fun getContentHeight(): Int {
//        var height = 0
//        val view = (context as? Activity)?.window?.decorView?.findViewById<FrameLayout>(android.R.id.content)
//        view?.let {
//            height = view.bottom
//        }
//        return height
//    }
//
//    /**
//     * 回收
//     */
//    fun release() {
//        // do something
//    }


