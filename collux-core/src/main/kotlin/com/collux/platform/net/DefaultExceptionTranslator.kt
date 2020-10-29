package com.collux.platform.net

import java.lang.Exception

/**
 * 默认的异常翻译策略
 * @author Siyi Lu
 * @since 2019/12/17
 */
object DefaultExceptionTranslator:  ExceptionTranslator{

    /**
     * 未定义错误码的异常
     */
    const val UNDEFINED_EXCEPTION_CODE = -1

    override fun canTranslate(exception: Exception): Boolean {
        return true
    }

    override fun readCode(exception: Exception): Int {
        return UNDEFINED_EXCEPTION_CODE
    }

    override fun readMessage(exception: Exception): String {
        return exception.message ?: "该异常[${exception.javaClass.simpleName}]未定义错误信息"
    }
}