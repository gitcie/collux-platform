package com.collux.platform.net

import org.springframework.core.MethodParameter
import org.springframework.core.annotation.Order
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

/**
 * web api统一响应数据格式转换器
 * @author Siyi Lu
 * @since 2019/12/18
 */
@ControllerAdvice(annotations = [RestController::class])
@Order(0)
class RestResponseConverter: ResponseBodyAdvice<Any> {

    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return converterType == MappingJackson2HttpMessageConverter::class.java
    }

    override fun beforeBodyWrite(
            body: Any?,
            returnType: MethodParameter,
            selectedContentType: MediaType,
            selectedConverterType: Class<out HttpMessageConverter<*>>,
            request: ServerHttpRequest,
            response: ServerHttpResponse): Any? {
        return if(body is RestResponse<*>) {
            return body
        }else{
            RestResponse<Any>().also {
                it.data = body
            }
        }
    }

}