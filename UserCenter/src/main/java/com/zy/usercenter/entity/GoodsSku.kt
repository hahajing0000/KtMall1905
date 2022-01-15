package com.zy.usercenter.entity

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/14 16:26
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/14 16:26
 * @updateRemark
 *
 * @version 1.0.0
 */
data class GoodsSku(
    val id: Int,
    val skuTitle: String,//SKU标题
    val skuContent: List<String>//SKU内容
)
