package com.develop1905.mvpcore

import android.util.Log
import com.develop1905.mvpcore.common.Model

/**
 * @author hahajing 企鹅：444511958
 * @createDate 2022/1/13 11:19
 * @description
 *
 * @updateUser hahajing
 * @updateDate 2022/1/13 11:19
 * @updateRemark
 *
 * @version 1.0.0
 */
abstract class BaseRepository {

    init {
        injectModels()
    }

    /**
     * 使用反射技术获取目标类上所有被@Model修饰的属性字段
     * 然后通过反射创建对应属性字段的实例
     * 然后赋值给对应属性即可
     * 从而达到一个数据仓库层对应多个Model层目的
     */
    private fun injectModels() {
        //获取到当前类型信息
        val clazz= this::class.java
        //通过获取到的类型信息拿到所有的Field
        val fields= clazz.declaredFields
        for (field in fields){
            //获取当前属性字段上是否有@Model注解
            val targetField= field.getAnnotation(Model::class.java)
            var fieldTypeName:String?=null
            if (targetField!=null){
                //找到对应字段就要对他实例化
                fieldTypeName=field.type.name
                if (null!=fieldTypeName){
                    val fieldClazz= Class.forName(fieldTypeName)
                    if (fieldClazz!=null){
                        field.isAccessible=true
                        val obj=fieldClazz.newInstance()
                        field.set(this,obj)
                    }
                }
            }
        }
    }

}