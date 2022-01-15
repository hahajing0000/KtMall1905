package com.develop1905.mvpcore.view

import com.develop1905.mvpcore.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

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
abstract class BaseMVPActivity<P: BasePresenter<*, *>>:BaseActivity(),CoroutineScope {
    protected val mPresenter:P
    val job:Job by lazy { Job() }
    init {
        mPresenter=createPresenter()
    }

    /**
     * 创建Presenter层
     */
    abstract fun createPresenter
                (): P

    override fun onStop() {
        super.onStop()
        if (null!=mPresenter){
            mPresenter.releaseJob()
        }
        if (null!=job){
            job.cancel()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job
}