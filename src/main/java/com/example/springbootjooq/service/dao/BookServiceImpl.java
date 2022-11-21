package com.example.springbootjooq.service.dao;

import com.example.springbootjooq.exception.DataNotFoundException;
import com.example.springbootjooq.model.tables.daos.BookDao;
import com.example.springbootjooq.model.tables.pojos.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service(value = "BookServiceDAO")
public class BookServiceImpl implements BookService {

    private final BookDao repository;

    @Override
    public Book create(Book book) {
        repository.insert(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        repository.update(book);
        return book;
    }

    @Override
    public List<Book> getAll(){
        return repository.findAll();
    }

    @Override
    public Book getOne(int id) {
        Book book = repository.findById(id);
        if(book == null){
           throw new DataNotFoundException(MessageFormat.format("Book id {0} not found", String.valueOf(id)));
        }
        return book;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}