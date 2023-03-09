 package com.MiPortfolio.Oscar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OscarApplication {

	public static void main(String[] args) {
		SpringApplication.run(OscarApplication.class, args);
	}

@Bean
public WebMvcConfigurer corsConfigurer(){
    return new WebMvcConfigurer(){
        @Override
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**").allowedOrigins("https://frontend1910-6bd06.web.app").allowedMethods("*").allowedHeaders("*");
 }
};
}
}
