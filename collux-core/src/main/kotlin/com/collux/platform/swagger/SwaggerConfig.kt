package com.collux.platform.swagger

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Parameter
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * SwaggerConfig
 * @author Siyi Lu
 * @since 2020/1/10
 */
@Configuration
@EnableSwagger2
open class SwaggerConfig {

    @Autowired
    private lateinit var swaggerProperties: SwaggerProperties

    @Autowired
    fun printSwaggerUrl(){
        Thread{
            println("接口文档地址：${swaggerProperties.serverUrl()}")
        }.start()

    }

    /**
     * 指定扫描包的路径来指定要创建API的目录，一般是控制器这个包
     * @return
     */
    @Bean
    open fun createRestApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerProperties.docket.enable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.docket.basePackage))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(initGlobalParameters())
    }

    @Bean
    open fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
                .title(swaggerProperties.title())
                .version(swaggerProperties.version())
                .termsOfServiceUrl(swaggerProperties.serverUrl())
                .description(swaggerProperties.api.description)
                .build()
    }

    private fun initGlobalParameters(): MutableList<Parameter>{
        return mutableListOf<Parameter>().also {
            val tokenParameter = ParameterBuilder().name("Authorization")
                    .description("token")
                    .parameterType("header")
                    .modelRef(ModelRef("string"))
                    .required(false)
                    .defaultValue("Bearer")
                    .build()
            it.add(tokenParameter)
        }
    }



}