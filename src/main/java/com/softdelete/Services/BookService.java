package com.softdelete.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdelete.Entity.Books;
import com.softdelete.Repo.BookRepo;

@Service
public class BookService {
    
    @Autowired
    private BookRepo bookRepo;

    public Books create(Books book){
        return bookRepo.save(book);
    }

    public void remove(Long id){
        bookRepo.deleteById(id);
    }

    public Iterable<Books> findAll(){
        return bookRepo.findAll();
    }
}
