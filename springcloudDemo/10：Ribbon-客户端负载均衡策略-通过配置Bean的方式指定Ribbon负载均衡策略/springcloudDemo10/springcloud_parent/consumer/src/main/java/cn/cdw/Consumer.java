package cn.cdw;

import cn.cdw.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author DW-CHEN
 * 服务消费者
 *
 * @RibbonClient配置Ribbon的负载均衡策略
 * name：设置服务提供方的应用名称
 * configuration：设置负载均衡的Bean
 *
 * 测试Ribbon自己指定负载均衡策略，启动多个不同端口服务提供者服务，看消费端查询观察ip变化是否是随机的
 */
@SpringBootApplication
@EnableEurekaClient  //启用eureka客户端
@RibbonClient(name = "provider",configuration = MyRule.class)
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
