package com.example.springbootjooq.service.dsl;


import com.example.springbootjooq.model.tables.pojos.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book update(Book book);

    List<Book> getAll();

    Book getOne(int id);

    void deleteById(int id);
}
