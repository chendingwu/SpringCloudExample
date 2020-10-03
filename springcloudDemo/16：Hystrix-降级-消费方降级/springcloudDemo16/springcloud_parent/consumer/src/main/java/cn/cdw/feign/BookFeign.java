package cn.cdw.feign;

import cn.cdw.feign.fallback.BookFeignFallBack;
import cn.cdw.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author DW-CHEN
 *
 * Feign声明是接口，发起远程调用用的
 *
 * 接口上使用@FeignClient设置value属性为服务提供者的应用名称,fallback属性是设置我们编写的降级处理类
 * 编写调用接口，接口声明规则和提供接口保持一致
 */
@FeignClient(value = "provider",fallback = BookFeignFallBack.class)  //指定服务提供者的应用名
public interface BookFeign {
    @RequestMapping("/book/{count}")
    public List<Book> booksFeign(@PathVariable("count") Integer count);  //定义要远程调用服务提供者的方法；注意：这里我一般都是从服务提供者的controller中复制对应的方法过来修改正确访问映射路径和方法名
}
