package cn.cdw.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DW-CHEN
 * 选择Ribbon的负载均衡规则
 *
 * RandomRule  随机规则
 *
 * RoundRobinRule    轮询规则
 *
 * BestAvailableRule   最小并法规则
 *
 * AvailabilityFilteringRule  过滤规则
 *
 * WeightedResponseTimeRule   响应时间规则
 *
 * RetryRule  轮询重试规则
 *
 * ZoneAvoidanceRule  性能可用性规则
 */
@Configuration
public class MyRule {

    @Bean
    public IRule rule() {
        return new RandomRule();  //负载均衡是随机规则
    }
}
