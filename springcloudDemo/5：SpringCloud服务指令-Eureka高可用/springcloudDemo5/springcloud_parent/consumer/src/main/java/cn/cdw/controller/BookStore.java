package cn.cdw.controller;

import cn.cdw.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DW-CHEN
 * 服务消费者控制层,需要远程调用服务提供者提供的数据
 * 通过DiscoveryClient动态的从eureka server中获取服务提供者的ip和端口,然后拼接路径，通过RestTemplate来远程调用服务提供者方法
 * 测试访问：http://localhost:8200/bookStore/5
 */
@RestController
public class BookStore {

    @Autowired  //注入RestTemplate，通过RestTemplate远程调用服务提供者方法
    private RestTemplate restTemplate;

    @Autowired  //注入DiscoveryClient对象,注意需要在启动引导类中激活DiscoveryClient
    private DiscoveryClient discoveryClient;

    @RequestMapping("/bookStore/{count}")
    public List<Book> bookStoreGetBooks(@PathVariable("count") Integer count) {
        List<ServiceInstance> provider = discoveryClient.getInstances("provider"); //通过DiscoveryClient对象从eureka服务中心根据应用名动态获取服务提供者的访问路径
        ServiceInstance serviceInstance = provider.get(0);
        String host = serviceInstance.getHost(); //动态获取host
        int port = serviceInstance.getPort();  //动态获取port

        String url = "http://"+host+":"+port+"/book/"+count;  //拼接url，就是访问服务提供者的路径地址
        ArrayList books = restTemplate.getForObject(url, ArrayList.class);  //远程调用服务提供者的方法

        //eureka高可用集群搭建，测试把其中一个服务停掉，看是否还能访问到数据
        return books;
    }
}
