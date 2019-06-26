package com.example.wangc.androiddemo

import android.support.v7.widget.RecyclerView

/**
 *
 * @ProjectName:    AndroidDemo2
 * @Package:        com.example.wangc.androiddemo
 * @ClassName:      MyLayoutManager
 * @Description:     java类作用描述
 * @Author:         wangc
 * @CreateDate:     2019/6/18 10:47
 * @Version:        1.0
 */
class MyLayoutManager : RecyclerView.LayoutManager() {
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        return super.scrollHorizontallyBy(dx, recycler, state)
    }

}
