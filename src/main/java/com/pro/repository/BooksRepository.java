package com.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.entity.Books;
@Repository
public interface BooksRepository  extends JpaRepository<Books, Integer>{

}
