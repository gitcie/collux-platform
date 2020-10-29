package com.collux.platform.net

/**
 * 响应状态
 * @author Siyi Lu
 * @since 2019/11/21
 */
enum class ResponseStatus(val code: Int, val message: String){

    SUCCESS(0, ""),

    BAD_REQUEST(400, "bad request")

}