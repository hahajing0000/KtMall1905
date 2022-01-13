package com.zy.usercenter.presenter

import android.os.Build
import com.develop1905.mvpcore.BasePresenter
import com.zy.usercenter.entity.UserEntity
import com.zy.usercenter.repository.UserCenterRepository
import com.zy.usercenter.view.IUserCenterView
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 16:14
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 16:14
 * @updateRemark
 *
 * @version 1.0.0
 */
class UserCenterPresenter(view:IUserCenterView): BasePresenter<UserCenterRepository, IUserCenterView>(view) {
    override fun createRepository(): UserCenterRepository {
        return UserCenterRepository()
    }

    /**
     * 模拟用户登录操作
     * @param userName 用户名
     * @param pwd 登录密码
     * @return 用户登录成功后的结果数据
     */
    fun login(userName:String,pwd:String): Unit {
        mRepository.login(userName,pwd).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :FlowableSubscriber<UserEntity>{
                override fun onSubscribe(s: Subscription) {
                    s.request(Int.MAX_VALUE.toLong())
                }

                override fun onNext(t: UserEntity?) {
                    mView.get()?.loginSuccess(t)
                }

                override fun onError(t: Throwable?) {
                    mView.get()?.loginFailed(t!!)
                }

                override fun onComplete() {

                }

            })
    }
}