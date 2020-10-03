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
 * 使用Ribbon简化RestTemplate调用
 * 测试访问：http://localhost:8200/bookStore/6
 */
@RestController
public class BookStore {

    @Autowired  //注入RestTemplate，通过RestTemplate远程调用服务提供者方法
    private RestTemplate restTemplate;


    @RequestMapping("/bookStore/{count}")
    public List<Book> bookStoreGetBooks(@PathVariable("count") Integer count) {

        String url = "http://provider/book/"+count;  //在使用RestTemplate发起请求时，需要定义url时，host:port可以替换为服务提供方的应用名称
        ArrayList books = restTemplate.getForObject(url, ArrayList.class);  //远程调用服务提供者的方法

        return books;
    }
}
