package com.softdelete.Repo;

import org.springframework.data.repository.CrudRepository;

import com.softdelete.Entity.Books;

public interface BookRepo extends CrudRepository<Books, Long> {
    
}
