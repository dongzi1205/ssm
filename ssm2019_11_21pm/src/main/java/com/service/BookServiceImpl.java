package com.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mapper.BookMapper;
import com.pojo.Book;
import com.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(String id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    //这是service层
    @Override
    public List<Book> selectAllBooks() {
        //在service层调用mapper通用接口的方法
        return bookMapper.selectAll();
    }

    @Override
    public List<Book> selectByBookId(Book book) {
        return bookMapper.select(book);
    }

    @Override
    public Book selectBookById3(String bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }

    @Override
    public Book selectBookById2(Book book) {
        return bookMapper.selectByPrimaryKey(book);
    }

}
