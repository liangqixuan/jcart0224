package io.lqx.jcartadministrationback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("io.lqx.jcartadministrationback.dao")
@EnableAsync //启用异步操作
public class JcartAdministrationBackApplication {


    public static void main(String[] args) {
        SpringApplication.run(JcartAdministrationBackApplication.class, args);
    }

}
