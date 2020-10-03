package cn.cdw;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author DW-CHEN
 * 服务消费者
 *
 * 使用Feign简化远程调用书写
 */
@SpringBootApplication
@EnableEurekaClient  //启用eureka客户端
@EnableFeignClients  //启用Feign功能
@EnableHystrixDashboard   //开启Hystrix仪表盘监控功能
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
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
