package com.example.springbootjooq.repositories;

import com.example.springbootjooq.model.tables.pojos.Author;
import com.example.springbootjooq.model.tables.records.AuthorRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

import static com.example.springbootjooq.model.Tables.AUTHOR;

@RequiredArgsConstructor
@Transactional
@Repository
public class AuthorRepository implements JOOQRepository<Author>{

    private final DSLContext context;

    @Override
    public Author save(Author author){
         AuthorRecord authorRecord = context.insertInto(AUTHOR)
                .set(AUTHOR.FIRSTNAME, author.getFirstname())
                .set(AUTHOR.LASTNAME, author.getLastname())
                .returning(AUTHOR.ID).fetchOne();

        if (authorRecord != null) {
            author.setId(authorRecord.getId());
            return author;
        }
        return null;
    }

    @Override
    public Author update(Author author, int id) {
        AuthorRecord authorRecord = context.update(AUTHOR)
                .set(AUTHOR.FIRSTNAME, author.getFirstname())
                .set(AUTHOR.LASTNAME, author.getLastname())
                .where(AUTHOR.ID.eq(5))
                .returning(AUTHOR.ID).fetchOne();

        return (authorRecord != null) ? author : null;
    }

    @Override
    public List<Author> findAll(){
        return context
                .selectFrom(AUTHOR)
                .fetchInto(Author.class);
    }
    @Override
    public Optional<Author> findById(int id){
        Author author = context.selectFrom(AUTHOR).where(AUTHOR.ID.eq(id)).fetchOneInto(Author.class);
        return (ObjectUtils.isEmpty(author)) ? Optional.empty() : Optional.of(author);
    }

    @Override
    public boolean deleteById(int id) {
        return context.delete(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .execute() == 1;
    }
}
