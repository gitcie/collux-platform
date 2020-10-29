package com.collux.platform.swagger

import org.springframework.stereotype.Component

/**
 * 对应Swagger创建一个{#ApiInfo}需要用到的属性
 * @author Siyi Lu
 * @since 2020/1/10
 */
@Component
class ApiProperties {

    var title: String = ""

    var description: String = ""

}