package com.divyansh.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divyansh.bookStore.entity.MyBook;

@Repository
public interface MybookRepository extends JpaRepository<MyBook,Integer>{
	
}
