package com.xuecheng.dictionaty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author Administrator
 * @version 1.0
 **/
//@EnableFeignClients //开始feignClient
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.system")//扫描实体类
@ComponentScan(basePackages={"com.xuecheng.api"})//扫描接口
//@ComponentScan(basePackages={"com.xuecheng.manage_course"})
@ComponentScan(basePackages={"com.xuecheng.framework"})//扫描common下的所有类
public class ManageDictionaryApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ManageDictionaryApplication.class, args);
    }
}
