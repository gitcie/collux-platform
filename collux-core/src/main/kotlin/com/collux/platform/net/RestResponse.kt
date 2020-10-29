package com.collux.platform.net

import cn.hutool.json.JSONUtil

/**
 * 统一的web api响应格式定义类
 * @author Siyi Lu
 * @since 2019/11/21
 */
class RestResponse<T> {

    var code: Int

    var error: String

    var data: T? = null

    init {
        ResponseStatus.SUCCESS.let {
            this.code = it.code
            this.error = it.message
        }
    }

    override fun toString(): String {
        return "code: $code，error: $error，data: ${JSONUtil.toJsonStr(data) ?: "数据为null"}"
    }

}