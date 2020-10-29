package com.collux.platform.net

/**
 * 响应异常接口
 * @author Siyi Lu
 * @since 2019/12/5
 */
interface ResponseException{

    fun code(): Int

    fun message(): String

}