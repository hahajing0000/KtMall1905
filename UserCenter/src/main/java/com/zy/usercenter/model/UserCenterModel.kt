package com.zy.usercenter.model

import android.os.SystemClock
import com.develop1905.mvpcore.IModel
import com.zy.usercenter.entity.UserEntity
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 16:02
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 16:02
 * @updateRemark
 *
 * @version 1.0.0
 */
class UserCenterModel constructor():IModel {

    /**
     * 模拟用户登录操作
     * @param userName 用户名
     * @param pwd 登录密码
     * @return 用户登录成功后的结果数据
     */
    fun login(userName:String,pwd:String):Flowable<UserEntity>{
        return Flowable.create(object :FlowableOnSubscribe<UserEntity>{
            override fun subscribe(emitter: FlowableEmitter<UserEntity>) {
                SystemClock.sleep(1000L)
                emitter.onNext(UserEntity("我是服务器请求的结果","",20,"天津"))
            }
        },BackpressureStrategy.LATEST)
    }
}