package com.divyansh.bookStore.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.divyansh.bookStore.entity.Book;
import com.divyansh.bookStore.entity.MyBook;
import com.divyansh.bookStore.service.BookService;
import com.divyansh.bookStore.service.MyBookService;

import org.springframework.ui.Model;

@Controller
public class Bookcontroller {
	
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private MyBookService mybookservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookregister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView availableBooks() {
		List<Book> bk = bookservice.getAllData();
		return new ModelAndView("availablebooks","books",bk);
	}
	
	@GetMapping("/my_books")
	public ModelAndView myBooks() {
		List<MyBook> mybook = mybookservice.getAllMyBooks();
		return new ModelAndView("MyBooks","mybooks",mybook);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookservice.save(b);
		return "redirect:/available_books";
	}
	
	
	@RequestMapping("/mybooks/{id}")
	public String getList(@PathVariable("id") int id) {
		Book book = bookservice.getBookById(id);
		MyBook mybook = new MyBook(id,book.getName(),book.getAuthor(),book.getPrice());
		mybookservice.save(mybook);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/delete_record/{id}")
	public String deleteMyBookItem(@PathVariable("id") int id) {
		mybookservice.deleteById(id);
		return "redirect:/my_books";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookservice.deleteBookById(id);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") int id , Model model) {
		Book book = bookservice.getBookById(id);
		model.addAttribute("books" , book);
		return "editBook";
	}
	
}
