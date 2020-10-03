package cn.cdw.service;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;

import cn.cdw.pojo.Book;
import java.util.ArrayList;
import java.util.List;


/**
 * @author DW-CHEN
 * 模拟生产者业务层
 */
@Service
public class BookService {

    public List<Book> getManyBook(Integer countBook) { //模拟你输出书的数量，我提供你指定的书对象数据给你
        ArrayList<Book> bookArrayList = new ArrayList<>();

        for (Integer i = 1; i <= countBook; i++) {
            Book book = new Book(i,"书本"+i,66.6);
            bookArrayList.add(book);
        }

        return bookArrayList;
    }

}
