package cn.cdw.controller;

import cn.cdw.pojo.Book;
import cn.cdw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DW-CHEN
 * 服务提供者控制层
 * 测试访问:http://localhost:8100/book/6
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book/{count}")
    public List<Book> books(@PathVariable("count") Integer count,String username) {
        System.out.println(username);  //测试配置的局部过滤是否进行添加请求参数和数据，测试访问：http://localhost/book/1
        return bookService.getManyBook(count);
    }
}
