package cn.cdw.feign.fallback;

import cn.cdw.feign.BookFeign;
import cn.cdw.pojo.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DW-CHEN
 *
 * Feign客户端降级处理类，实现Feign客户端的接口
 * 使用@Component将该类加入IOC容器
 */

@Component
public class BookFeignFallBack implements BookFeign {
    @Override
    public List<Book> booksFeign(Integer count) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        Book book = new Book();
        book.setName("服务消费端的服务被降级处理了");
        bookArrayList.add(book);

        return  bookArrayList;
    }
}
