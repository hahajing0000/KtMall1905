package com.zy.usercenter.model.api

import com.develop1905.net.entity.BaseResp
import com.zy.usercenter.entity.GetGoodsListReq
import com.zy.usercenter.entity.Goods
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/14 16:24
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/14 16:24
 * @updateRemark
 *
 * @version 1.0.0
 */
interface GoodsApi {
    /*
        获取商品列表
     */
    @POST("goods/getGoodsList")
    fun getGoodsList(@Body req: GetGoodsListReq): Deferred<BaseResp<MutableList<Goods>?>>
}