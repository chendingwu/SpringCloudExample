package cn.cdw.controller;

import cn.cdw.feign.BookFeign;
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
 * 使用Feign简化远程调用
 * 测试访问：http://localhost:8200/bookStore/6
 */
@RestController
public class BookStore {

    @Autowired  //注入刚才定义的Feign声明是接口
    private BookFeign bookFeign;

    @RequestMapping("/bookStore/{count}")
    public List<Book> bookStoreGetBooks(@PathVariable("count") Integer count) {

        List<Book> books = bookFeign.booksFeign(count);  //通过刚才注入的Feign接口，直接调用该接口中的方法即可
        return books;
    }
}
