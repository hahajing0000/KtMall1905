package com.develop1905.net.ext

import com.develop1905.net.entity.BaseResp
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/15 9:03
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/15 9:03
 * @updateRemark
 *
 * @version 1.0.0
 */

suspend fun <T> Deferred<T>.doResult(success:(BaseResp<*>)->Unit,failed:(Throwable)->Unit,completed:Deferred<T>.()->Unit){

    try {
        val reuslt = this.await() as BaseResp<*>
        if(reuslt.status==0){
            failed(Throwable(reuslt.message))
        }else{
            success(reuslt)
        }
    }catch (ex:Throwable){
        failed(ex)
    }
    finally {
        completed()
    }

}