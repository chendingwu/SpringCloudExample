package cn.cdw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author DW-CHEN
 * 通过RestTemplate远程调用服务提供者，首先需要把RestTemplate添加到IOC容器
 */
@Configuration
public class BookConfig {

    @Bean   //把RestTemplate添加到IOC容器
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }
}
