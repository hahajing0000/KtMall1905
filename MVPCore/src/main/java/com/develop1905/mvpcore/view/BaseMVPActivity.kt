package com.develop1905.mvpcore.view

import com.develop1905.mvpcore.BasePresenter

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 15:21
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 15:21
 * @updateRemark
 *
 * @version 1.0.0
 */
abstract class BaseMVPActivity<P: BasePresenter<*, *>>:BaseActivity() {
    protected val mPresenter:P
    init {
        mPresenter=createPresenter()
    }

    /**
     * 创建Presenter层
     */
    abstract fun createPresenter
                (): P

}