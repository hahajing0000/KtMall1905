package com.zy.usercenter.view

import com.develop1905.mvpcore.IView

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 16:15
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 16:15
 * @updateRemark
 *
 * @version 1.0.0
 */
interface IUserCenterView:IView {
    fun <T> loginSuccess(data:T)
    fun loginFailed(throwable: Throwable)
}