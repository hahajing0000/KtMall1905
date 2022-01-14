package com.develop1905.mvpcore

import java.lang.ref.SoftReference

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
abstract class BasePresenter<Repo:BaseRepository,V:IView>(view:V) {
    protected val mRepository:Repo
    protected val mView:SoftReference<V>
    init {
        mView=SoftReference(view)
        mRepository=createRepository()
    }

    /**
     * 创建数据仓库层
     */
    abstract fun createRepository(): Repo
}