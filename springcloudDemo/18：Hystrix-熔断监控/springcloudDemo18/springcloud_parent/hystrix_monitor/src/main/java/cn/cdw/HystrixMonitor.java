package cn.cdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author DW-CHEN
 * 聚合监控微服务
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTurbine   //开启Turbine 聚合监控功能
@EnableHystrixDashboard   //开启Hystrix仪表盘监控功能
public class HystrixMonitor {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMonitor.class);
    }
}
