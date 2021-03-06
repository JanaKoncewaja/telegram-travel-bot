package com.telegram.bot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.ApiContextInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.logging.Logger;

@SpringBootApplication
@EnableSwagger2
public class SpringBootApplication2 {

    public static void main(String[] args) {
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("socksProxyHost", "127.0.0.1");
        System.getProperties().put("socksProxyPort", "9150");
        ApiContextInitializer.init();
        SpringApplication.run(SpringBootApplication2.class, args);
    }

    @Bean
    public Logger serviceLogger() {
        return Logger.getLogger("CityService");
    }

    @Bean
    public Logger controllerLogger() {
        return Logger.getLogger("CityController");
    }

    @Bean
    public Logger chatBotLogger(){
        return Logger.getLogger("ChatBot");
    }

}
