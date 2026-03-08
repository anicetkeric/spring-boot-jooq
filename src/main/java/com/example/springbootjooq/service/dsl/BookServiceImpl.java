package com.example.springbootjooq.service.dsl;

import com.example.springbootjooq.exception.BadRequestException;
import com.example.springbootjooq.exception.DataNotFoundException;
import com.example.springbootjooq.model.tables.pojos.Book;
import com.example.springbootjooq.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@RequiredArgsConstructor
@Service(value = "BookServiceDSL")
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public Book create(Book book) {
        return repository.save(book);
    }

    @Override
    public Book update(Book book) {
        return repository.update(book, book.getId());
    }

    @Override
    public List<Book> getAll(){
        return repository.findAll();
    }

    @Override
    public Book getOne(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new DataNotFoundException(
                                MessageFormat.format("Book with id {0} not found", id)
                        ));
    }

    @Override
    public void deleteById(int id) {
        if (!repository.deleteById(id)) {
            throw new BadRequestException(
                    MessageFormat.format("Failed to delete book with id {0}", id)
            );
        }
    }

}