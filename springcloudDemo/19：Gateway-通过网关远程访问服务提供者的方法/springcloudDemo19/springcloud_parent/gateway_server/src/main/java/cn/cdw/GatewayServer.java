package cn.cdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author DW-CHEN
 * geteway网关
 * 启动服务提供者provider，然后启动gateway_server网关，测试通过网关访问是否可以访问到服务提供者的方法
 * 测试访问:http://localhost/book/6
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServer.class);
    }
}
