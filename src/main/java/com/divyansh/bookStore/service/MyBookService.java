package com.divyansh.bookStore.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divyansh.bookStore.entity.MyBook;
import com.divyansh.bookStore.repository.MybookRepository;

@Service
public class MyBookService {
	
	@Autowired
	MybookRepository repo;
	
	public void save(MyBook book) {
		repo.save(book);
	}
	
	public List<MyBook> getAllMyBooks(){
		return repo.findAll();
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
