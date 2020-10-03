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
    public List<Book> books(@PathVariable("count") Integer count) throws InterruptedException {

        //测试把服务提供者关闭，服务消费端远程通过Feign远程嗲用服务提供者默认1秒连接不上就会报connect timed out executing连接超时异常
        Thread.sleep(2000); //测试Feign远程读取数据超时，消费端通用Feign远程调用服务提供方数据默认为1秒读取不到就会Read timed out executing读取报超时，我在服务提供方这里设置了睡眠两秒后再返回数据

        return bookService.getManyBook(count);
    }
}
