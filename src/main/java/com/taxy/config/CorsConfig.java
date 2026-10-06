package com.taxy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry
            // Apply CORS configuration to all backend APIs
            .addMapping("/api/**")

            .allowedOrigins(
            	    "http://localhost:5173",  // React
            	    "http://localhost:4200"   // Angular
            	)

            // HTTP methods React is allowed to call
            .allowedMethods(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "OPTIONS"
            )

            // Allow request headers such as Content-Type
            .allowedHeaders("*");
    }
}
