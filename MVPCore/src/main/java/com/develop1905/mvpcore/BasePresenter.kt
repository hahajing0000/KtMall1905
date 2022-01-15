package com.develop1905.mvpcore

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import java.lang.ref.SoftReference
import kotlin.coroutines.CoroutineContext

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 11:28
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 11:28
 * @updateRemark
 *
 * @version 1.0.0
 */
abstract class BasePresenter<Repo:BaseRepository,V:IView>(view:V):CoroutineScope {
    protected val mRepository:Repo
    protected val mView:SoftReference<V>

    val job:Job

    init {
        mView=SoftReference(view)
        mRepository=createRepository()
        job= Job()
    }

    /**
     * 创建数据仓库层
     */
    abstract fun createRepository(): Repo

    override val coroutineContext: CoroutineContext
        get() = job

    /**
     * 取消Job 避免内存泄漏
     */
    fun releaseJob(){
        if (null!=job){
            job.cancel()
        }
    }
}