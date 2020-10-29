package com.collux.platform.project

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * 从application.yml中读取的项目配置信息
 * @author Siyi Lu
 * @since 2020/1/10
 */
@Component
internal class Project {

    @Value("\${spring.application.name}")
    var name: String = ""

    @Value("\${project.version}")
    var artifactVersion: String = "0.0.1-SNAPSHOT"

}