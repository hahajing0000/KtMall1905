package com.develop1905.mvpcore.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 15:13
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 15:13
 * @updateRemark
 *
 * @version 1.0.0
 */
abstract class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
        initView(savedInstanceState)
        initData()
        initEvent()
    }

    abstract fun getLayoutId(): Int

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化视图
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 跳转到指定的activity
     */
    fun jumpActivity(target: Class<*>){
        startActivity(Intent(this@BaseActivity,target))
    }

    /**
     * 吐丝
     */
    fun showMsg(msg:String){
        Toast.makeText(this@BaseActivity,msg,Toast.LENGTH_SHORT).show()
    }

    fun showLoading(){

    }

    fun hideLoading(){

    }
}