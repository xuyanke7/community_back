package com.xuyifan.communityback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.xuyifan.communityback.mapper")
@SpringBootApplication
public class CommunitybackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunitybackApplication.class, args);
    }

}
