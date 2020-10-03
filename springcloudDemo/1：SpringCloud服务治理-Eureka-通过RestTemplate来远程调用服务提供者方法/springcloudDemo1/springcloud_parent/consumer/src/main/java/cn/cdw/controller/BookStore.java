package cn.cdw.controller;

import cn.cdw.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DW-CHEN
 * 服务消费者控制层,需要远程调用服务提供者提供的数据
 * 启动服务端，然后启动消费端测试访问:http://localhost:9100/bookStore/10
 */
@RestController
public class BookStore {

    @Autowired  //注入RestTemplate，通过RestTemplate远程调用服务提供者方法
    private RestTemplate restTemplate;

    @RequestMapping("/bookStore/{count}")
    public List<Book> bookStoreGetBooks(@PathVariable("count") Integer count) {
        String url = "http://localhost:8100/book/"+count;
        ArrayList books = restTemplate.getForObject(url, ArrayList.class);  //远程调用服务提供者的方法

        return books;
    }
}
