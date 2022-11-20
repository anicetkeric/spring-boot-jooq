package com.example.springbootjooq.repositories;

import com.example.springbootjooq.model.tables.pojos.Book;
import com.example.springbootjooq.model.tables.records.BookRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

import static com.example.springbootjooq.model.Tables.BOOK;

@RequiredArgsConstructor
@Transactional
@Repository
public class BookRepository implements JOOQRepository<Book> {

    private final DSLContext context;

    @Override
    public Book save(Book book){
        BookRecord bookRecord = context.insertInto(BOOK)
                .set(BOOK.DESCRIPTION, book.getDescription())
                .set(BOOK.ISBN, book.getIsbn())
                .set(BOOK.PAGE, book.getPage())
                .set(BOOK.PRICE, book.getPrice())
                .set(BOOK.TITLE, book.getTitle())
                .set(BOOK.AUTHOR_ID, book.getAuthorId())
                .returning(BOOK.ID).fetchOne();

        if (bookRecord != null) {
            book.setId(bookRecord.getId());
            return book;
        }
        return null;
    }

    @Override
    public Book update(Book book, int id) {
        BookRecord bookRecord = context.update(BOOK)
                .set(BOOK.DESCRIPTION, book.getDescription())
                .set(BOOK.ISBN, book.getIsbn())
                .set(BOOK.PAGE, book.getPage())
                .set(BOOK.PRICE, book.getPrice())
                .set(BOOK.TITLE, book.getTitle())
                .set(BOOK.AUTHOR_ID, book.getAuthorId())
                .where(BOOK.ID.eq(5))
                .returning(BOOK.ID).fetchOne();

        return (bookRecord != null) ? book : null;
    }

    @Override
    public List<Book> findAll(){
        return context
                .selectFrom(BOOK)
                .fetchInto(Book.class);
    }
    @Override
    public Optional<Book> findById(int id){
        Book book = context.selectFrom(BOOK).where(BOOK.ID.eq(id)).fetchOneInto(Book.class);
        return (ObjectUtils.isEmpty(book)) ? Optional.empty() : Optional.of(book);
    }

    @Override
    public boolean deleteById(int id) {
        return context.delete(BOOK)
                .where(BOOK.ID.eq(id))
                .execute() == 1;
    }

}
