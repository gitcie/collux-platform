package com.collux.platform.swagger

import com.collux.platform.project.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.stereotype.Component

/**
 * swagger自动配置属性
 * @author Siyi Lu
 * @since 2020/1/10
 */
@Component
@ConfigurationProperties(prefix = "swagger")
internal class SwaggerProperties {

    @NestedConfigurationProperty
    val docket: DocketProperties = DocketProperties()

    @NestedConfigurationProperty
    val api: ApiProperties = ApiProperties()

    @Autowired
    lateinit var localServerUrl: LocalServerUrl

    @Autowired
    lateinit var project: Project

    fun title(): String{
        return "${project.name} API文档".takeIf {
            api.title.isBlank()
        } ?: api.title
    }

    fun version(): String{
        return project.artifactVersion
    }

    fun serverUrl(): String{
        return "${localServerUrl}/swagger-ui.html"
    }

}