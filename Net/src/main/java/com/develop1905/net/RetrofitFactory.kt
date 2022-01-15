package com.develop1905.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/14 15:56
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/14 15:56
 * @updateRemark
 *
 * @version 1.0.0
 */
object RetrofitFactory {
    private val retrofit: Retrofit
    init {
        retrofit= createRetrofit()
    }

    /**
     * 创建Retrofit实例方法
     */
    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .client(createOkHttpClient())
            .build()
    }

    /**
     * 创建OkHttpClient
     */
    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(createHttpInterceptor())
//            .addInterceptor(createTokenInterceptor())
            .build()
    }

    /**
     * 创建自定义拦截器 用于处理Token
     */
    private fun createTokenInterceptor(): Interceptor {
        val interceptor:Interceptor= Interceptor {
            null
        }
        return interceptor
    }

    /**
     * 添加日志拦截器
     */
    private fun createHttpInterceptor(): Interceptor {
        val httpLoggingInterceptor=HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    /**
     * 创建api实例方法
     */
    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}