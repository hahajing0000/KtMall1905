package com.zy.usercenter.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.develop1905.mvpcore.view.BaseMVPActivity
import com.develop1905.net.RetrofitFactory
import com.develop1905.net.ext.doResult
import com.zy.usercenter.R
import com.zy.usercenter.entity.GetGoodsListReq
import com.zy.usercenter.model.api.GoodsApi
import com.zy.usercenter.presenter.UserCenterPresenter
import com.zy.usercenter.view.IUserCenterView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.*
import org.jetbrains.anko.*
import kotlin.coroutines.CoroutineContext

class LoginActivity() : BaseMVPActivity<UserCenterPresenter>(), IUserCenterView, AnkoLogger {


    override fun initEvent() {
        btn_usercenter_login.setOnClickListener {

            var result = RetrofitFactory.create(GoodsApi::class.java)
            var defferd = result.getGoodsList(GetGoodsListReq(1, 1))


            launch(Dispatchers.IO) {
                val that = this
                defferd.doResult(
                    { r ->
                        CoroutineScope(Dispatchers.Main).launch {
                            Log.d("123", "initEvent: $r")
                        }
                    },
                    { e ->
                        CoroutineScope(Dispatchers.Main).launch {
                            Log.e("123", "error:${e.message}")
                        }
                    },
                    {

                    })

            }
        }
    }

    override fun initData() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun createPresenter(): UserCenterPresenter {
        return UserCenterPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun <T> loginSuccess(data: T) {
        showMsg("恭喜 登录成功")
    }

    override fun loginFailed(throwable: Throwable) {
        showMsg("哎呀 登录失败了")
    }
}