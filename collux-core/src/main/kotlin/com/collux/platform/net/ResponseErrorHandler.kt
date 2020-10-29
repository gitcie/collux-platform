package com.collux.platform.net

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.WebApplicationContext

/**
 * class summary
 * <p>
 * class detail description
 * @author Siyi Lu
 * @since 2019/11/21
 */
@RestControllerAdvice
class ResponseErrorHandler {

    companion object{
        val logger = LoggerFactory.getLogger(RestResponseConverter::class.java)
    }

    @Autowired
    private var context: WebApplicationContext? = null

    @ExceptionHandler(Exception::class)
    fun apiExceptionHandler(exception: Exception): RestResponse<String>{
        logger.info("系统内部错误：${exception.message}")
        val translator = lookupExceptionTranslators(exception)
        return RestResponse<String>().also {
            it.code = translator.readCode(exception)
            it.error = translator.readMessage(exception)
        }
    }

    /**
     * 查询所有实现ExceptionTranslator的Bean集合
     */
    private fun lookupExceptionTranslators(exception: Exception): ExceptionTranslator{
        var translator: ExceptionTranslator? = null
        context?.getBeansOfType(ExceptionTranslator::class.java)?.apply {
            for(name in this.keys){
                if(this[name]?.canTranslate(exception) == true){
                    translator = this[name]
                    break
                }
            }
        }
        return translator ?: DefaultExceptionTranslator
    }

}