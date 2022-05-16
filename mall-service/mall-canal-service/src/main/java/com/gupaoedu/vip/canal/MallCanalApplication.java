package com.gupaoedu.vip.canal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(basePackages = {"com.gupaoedu.vip.mall.goods.feign"})
public class MallCanalApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallCanalApplication.class,args);
    }
}
