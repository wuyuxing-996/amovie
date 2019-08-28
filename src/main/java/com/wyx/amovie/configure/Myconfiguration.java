package com.wyx.amovie.configure;

import com.wyx.amovie.utils.Myproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author wyx
 * @date 2019-08-28 09:55
 */
@Configuration
public class Myconfiguration implements WebMvcConfigurer {

    @Autowired
    private Myproperties myproperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations(
                "file:" + myproperties.getFilepath() + File.separator);
    }
}
