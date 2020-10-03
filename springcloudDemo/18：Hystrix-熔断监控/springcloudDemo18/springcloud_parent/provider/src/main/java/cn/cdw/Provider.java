package cn.cdw;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author DW-CHEN
 * 服务提供者
 */
@SpringBootApplication
@EnableEurekaClient  //启用Eureka客户端
@EnableCircuitBreaker  //启动Hystrix
@EnableHystrixDashboard   //开启Hystrix仪表盘监控功能
public class Provider {
    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {

        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        servletRegistrationBean.setName("hystrixMetricsStreamServlet");

        return servletRegistrationBean;
    }
}
