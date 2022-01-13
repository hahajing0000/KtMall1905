package com.zy.usercenter.repository

import com.develop1905.mvpcore.BaseRepository
import com.zy.usercenter.entity.UserEntity
import com.zy.usercenter.model.UserCenterModel
import io.reactivex.Flowable

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 16:11
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 16:11
 * @updateRemark
 *
 * @version 1.0.0
 */
class UserCenterRepository: BaseRepository<UserCenterModel>() {
    override fun createModel(): UserCenterModel {
        return UserCenterModel()
    }

    /**
     * 模拟用户登录操作
     * @param userName 用户名
     * @param pwd 登录密码
     * @return 用户登录成功后的结果数据
     */
    fun login(userName:String,pwd:String): Flowable<UserEntity> {

        return mModel.login(userName,pwd)
    }
}