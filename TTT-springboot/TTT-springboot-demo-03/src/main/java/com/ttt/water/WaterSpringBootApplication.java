package com.ttt.water;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ttt.water.mapper")
public class WaterSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(WaterSpringBootApplication.class, args);
    }
}
