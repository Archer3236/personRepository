package com.archer.config;

import com.archer.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
    @Bean
    public Person person(){
        return new Person("zhangsan",16);
    }
}
