package com.softdelete.Services;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdelete.Entity.Books;
import com.softdelete.Repo.BookRepo;

@Service
public class BookService {
    
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookRepo bookRepo;

    public Books create(Books book){
        return bookRepo.save(book);
    }

    public void remove(Long id){
        bookRepo.deleteById(id);
    }

    public Iterable<Books> findAll(boolean isDeleted){
        // return bookRepo.findAll();

        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBookFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Books> book = bookRepo.findAll();
        session.disableFilter("deletedBookFilter");

        return book;
    }
}
