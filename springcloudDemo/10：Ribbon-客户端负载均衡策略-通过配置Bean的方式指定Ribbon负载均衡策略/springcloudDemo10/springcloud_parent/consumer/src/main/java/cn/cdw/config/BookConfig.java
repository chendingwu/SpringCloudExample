package cn.cdw.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author DW-CHEN
 * 通过RestTemplate远程调用服务提供者，首先需要把RestTemplate添加到IOC容器
 *
 * 使用Ribbon简化RestTemplate调用
 * 在声明RestTemplate为Bean的时候，添加@LoadBalanced
 */
@Configuration
public class BookConfig {

    @Bean   //把RestTemplate添加到IOC容器
    @LoadBalanced
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }
}
