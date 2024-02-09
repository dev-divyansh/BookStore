package com.divyansh.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divyansh.bookStore.entity.Book;

@Repository
public interface JavaRepository extends JpaRepository<Book,Integer>{
	
}
