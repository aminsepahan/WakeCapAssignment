package com.wakecap.android.assignment.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Amin on 15/12/2017.
 */
class ItemDecorationPadding(val paddingTop: Int, val column: Int) : RecyclerView.ItemDecoration() {

    constructor(paddingTop: Int) : this(paddingTop, 1)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemCount = state.itemCount

        val itemPosition = parent.getChildAdapterPosition(view)

        // no position, leave it alone
        if (itemPosition == RecyclerView.NO_POSITION) {
            return
        }

        // first item
        if (itemPosition < column) {
            outRect.set(
                view.paddingLeft,
                dpToPixels(paddingTop.toFloat()),
                view.paddingRight,
                view.paddingBottom
            )
        } else if (itemCount > 0 && itemPosition == itemCount - 1) {
            outRect.set(view.paddingLeft, view.paddingTop, view.paddingRight, dpToPixels(50f))
        } else {
            outRect.set(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)
        }// every other item
        // last item
    }


    fun dpToPixels(dp: Float): Int {
        val scale = App.app.resources.displayMetrics.density
        return (dp * scale).toInt()
    }

}