package com.faon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class SotoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SotoApplication.class, args);
    }


//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(SotoApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(SotoApplication.class, args);
//    }

}
