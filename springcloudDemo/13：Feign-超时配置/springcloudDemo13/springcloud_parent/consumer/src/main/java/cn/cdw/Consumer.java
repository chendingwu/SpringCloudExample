package cn.cdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author DW-CHEN
 * 服务消费者
 *
 * 使用Feign简化远程调用书写
 */
@SpringBootApplication
@EnableEurekaClient  //启用eureka客户端
@EnableFeignClients  //启用Feign功能
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
