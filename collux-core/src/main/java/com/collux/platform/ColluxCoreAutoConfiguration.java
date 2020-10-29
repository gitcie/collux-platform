package com.collux.platform;

import com.collux.platform.swagger.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 * @author zyx
 * @since 2020/8/22
 */
@EnableConfigurationProperties({
        SwaggerProperties.class
})
@Configuration
@ComponentScan
public class ColluxCoreAutoConfiguration {

}
