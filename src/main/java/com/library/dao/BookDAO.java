package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Book;

public interface BookDAO {
	
	void addBook(Book book) throws SQLException;
	Book getBookById(int id) throws SQLException;
	List<Book> getAllBooks() throws SQLException;
	void updateBook(Book book) throws SQLException;
	void deleteBook(int id) throws SQLException;
} 
