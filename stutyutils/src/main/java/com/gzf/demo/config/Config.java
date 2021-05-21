package com.gzf.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: demoList
 * @description: 配置文件
 * @author: Gaozf
 * @create: 2019-12-27 14:54
 **/
@Configuration
public class Config extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String os = System.getProperty("os.name");

        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            registry.addResourceHandler("/smallapple/**")
                    // /apple/**表示在磁盘apple目录下的所有资源会被解析为以下的路径
                    .addResourceLocations("file:G:/itemsource/smallapple/") //媒体资源
                    .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面
        } else {  //linux 和mac
            registry.addResourceHandler("/Users/gzf/Downloads/**")
                    .addResourceLocations("file:/Users/gzf/Downloads/")   //媒体资源
                    .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面;
        }
    }
}
