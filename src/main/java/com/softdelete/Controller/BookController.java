package com.softdelete.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softdelete.Entity.Books;
import com.softdelete.Services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PostMapping
    public Books createOne(@RequestBody Books book){
        return bookService.create(book);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        bookService.remove(id);
    }

    @GetMapping
    public Iterable<Books> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted){
        return bookService.findAll(isDeleted);
    }
    
}
