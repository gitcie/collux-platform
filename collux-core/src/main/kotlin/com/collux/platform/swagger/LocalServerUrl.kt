package com.collux.platform.swagger

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * 本地服务接口地址，从配置中读取
 * @author Siyi Lu
 * @since 2020/1/10
 */
@Component
class LocalServerUrl {

    @Value("\${server.port}")
    private var port: Int = 8080

    @Value("\${server.servlet.context-path}")
    private var path: String = "/"

    override fun toString(): String {
        return "http://localhost:$port$path"
    }

}