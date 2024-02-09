package com.divyansh.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divyansh.bookStore.entity.Book;
import com.divyansh.bookStore.repository.JavaRepository;
import com.divyansh.bookStore.repository.MybookRepository;

@Service
public class BookService {
	
	@Autowired
	private JavaRepository repo;
	
	@Autowired
	private MybookRepository bookrepo;
	
	public void save(Book b) {
		repo.save(b);
	}
	
	public  List<Book> getAllData(){
		return repo.findAll();
	}
	
	public Book getBookById(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteBookById(int id) {
		repo.deleteById(id);
		bookrepo.deleteById(id);
	}
	
	public void editBook(int id) {
		
	}
}
