package com.collux.platform.net

import java.lang.Exception

/**
 * 异常信息翻译策略接口
 * @author Siyi Lu
 * @since 2019/12/17
 */
interface ExceptionTranslator {

    fun canTranslate(exception: Exception): Boolean

    fun readCode(exception: Exception): Int

    fun readMessage(exception: Exception): String

}