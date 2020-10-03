package cn.cdw.controller;

import cn.cdw.pojo.Book;
import cn.cdw.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DW-CHEN
 * 服务提供者控制层
 *
 * 服务提供方服务降级处理
 *
 * fallbackMethod：指定降级后调用的方法名称,默认1秒熔断降级。就是如果过了1秒还是没有获取到服务提供者的数据，就会熔断降级
 * commandProperties 设置熔断的时间
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book/{count}")
    @HystrixCommand(fallbackMethod = "fallBackBooks",commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")} ) //设置3秒内获取到服务提供者的数据就不会熔断处理
    public List<Book> books(@PathVariable("count") Integer count) throws InterruptedException {
       //int i =1/0; //测试出现异常，服务提供方是否降级处理
       // Thread.sleep(2000); //测试熔断时间设置，我设置了3秒熔断，这里睡眠2秒返回数据，所以不会被熔断降级处理（测试访问：http://localhost:8100/book/6）；但如果是消费端Feign远程调用会报读取超时，因为默认读取时间为1秒
        return bookService.getManyBook(count);
    }


    /**
     * @author DW-CHEN
     * 服务提供方服务降级
     *
     * 1：方法的返回值需要和原方法一样
     * 2：方法的参数需要和原方法一样
     */
    public List<Book> fallBackBooks(@PathVariable("count") Integer count){
        ArrayList<Book> bookArrayList = new ArrayList<>();
        Book book = new Book();
        book.setName("服务提供方降级处理了");
        bookArrayList.add(book);

        return bookArrayList;
    }
}
