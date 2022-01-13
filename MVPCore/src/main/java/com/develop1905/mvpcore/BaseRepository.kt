package com.develop1905.mvpcore

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 11:19
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 11:19
 * @updateRemark
 *
 * @version 1.0.0
 */
abstract class BaseRepository<M:IModel> {
    protected val mModel:M
    init {
        mModel=createModel()
    }

    /**
     * 创建Model层
     */
    abstract fun createModel(): M
}