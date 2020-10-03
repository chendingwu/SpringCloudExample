package cn.cdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author DW-CHEN
 * 服务消费者
 * 启动多个不同端口号的服务提供者的微服务，然后测试通过查看端口号的变化指定Ribbon的负载均衡默认是轮询
 */
@SpringBootApplication
@EnableEurekaClient  //启用eureka客户端
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
