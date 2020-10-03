package cn.cdw;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DW-CHEN
 * 自定义指定Feign日志级别
 * 然后在Feign接口中启用我们定义的Feign日志级别
 *
 * NONE： 不记录
 * BASIC： 记录基本的请求行，响应状态码数据
 * HEADERS：记录基本的请求行，响应状态码数据，记录响应头信息
 * FULL：记录完整的请求，和响应的数据
 */
@Configuration
public class LoggingLevelConfig {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;  //记录完整的请求和响应的数据
    }
}
