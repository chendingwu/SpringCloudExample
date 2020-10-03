package cn.cdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author DW-CHEN
 * Eureka Server服务
 */
@SpringBootApplication
@EnableEurekaServer  //启用eureka server
public class EurekaServer1 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer1.class, args);
    }
}
