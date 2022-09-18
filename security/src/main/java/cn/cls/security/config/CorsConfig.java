package cn.cls.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOrigins("*")
                // 允许cookie
                .allowCredentials(true)
                // 允许请求方法
                .allowedMethods("*")
                // 设施header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }
}
