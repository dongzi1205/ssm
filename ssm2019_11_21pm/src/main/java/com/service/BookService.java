package com.service;

import com.pojo.Book;

import java.util.List;

public interface BookService {


    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectAllBooks();

    List<Book> selectByBookId(Book book);

    Book selectBookById2(Book book);

    Book selectBookById3(String bid);

}
