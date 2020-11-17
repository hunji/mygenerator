package com.youhualife.mygenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.youhualife.*.dao")
public class MyGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyGeneratorApplication.class, args);
    }

}
