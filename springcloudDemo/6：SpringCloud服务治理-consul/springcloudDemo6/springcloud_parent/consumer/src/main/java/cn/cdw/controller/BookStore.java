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
 * 服务消费者控制层,通过consul远程调用服务提供者提供的方法
 * 启动服务端，然后启动消费端测试访问:http://localhost:8200/bookStore/6
 */
@RestController
public class BookStore {

    @Autowired  //注入RestTemplate，通过RestTemplate远程调用服务提供者方法
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/bookStore/{count}")
    public List<Book> bookStoreGetBooks(@PathVariable("count") Integer count) {
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        ServiceInstance serviceInstance = provider.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();

        String url = "http://"+host+":"+port+"/book/"+count;
        ArrayList books = restTemplate.getForObject(url, ArrayList.class);  //远程调用服务提供者的方法

        return books;
    }
}
