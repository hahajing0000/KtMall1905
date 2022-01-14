package com.zy.usercenter.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.develop1905.mvpcore.view.BaseMVPActivity
import com.zy.usercenter.R
import com.zy.usercenter.presenter.UserCenterPresenter
import com.zy.usercenter.view.IUserCenterView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

class LoginActivity : BaseMVPActivity<UserCenterPresenter>(),IUserCenterView,AnkoLogger {

//    private lateinit var etUsercenterUsername: EditText
//    private lateinit var etUsercenterPwd:EditText
//    private lateinit var btnUsercenterLogin: Button


    override fun initEvent() {
        btn_usercenter_login.setOnClickListener {
            val username=et_usercenter_username.text.toString()
            val pwd=et_usercenter_pwd.text.toString()
            mPresenter.login(username,pwd)

        }
    }

    override fun initData() {

    }

    override fun initView(savedInstanceState: Bundle?) {
//        etUsercenterUsername=findViewById(R.id.et_usercenter_username)
//        etUsercenterPwd=findViewById(R.id.et_usercenter_pwd)
//        btnUsercenterLogin=findViewById(R.id.btn_usercenter_login)
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