package com.mytutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan("com.mytutor")
@SpringBootApplication
public class SpringRestExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestExampleApplication.class, args);
		// System.out.println(( (RESTClientExample)
		// context.getBean("restClient")).getAllEmployees());
	}
	
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
            }
        };
    }

	/*
	 * @Bean public RestTemplate geRestTemplate() { return new RestTemplate(); }
	 */
}
