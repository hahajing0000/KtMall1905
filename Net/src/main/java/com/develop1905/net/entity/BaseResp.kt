package com.develop1905.net.entity

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/14 16:25
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/14 16:25
 * @updateRemark
 *
 * @version 1.0.0
 */
data class BaseResp<out T>(val status:Int, val message:String, val data:T)