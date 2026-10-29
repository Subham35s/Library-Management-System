package com.library.service;

import java.sql.SQLException;
import java.util.List;

import com.library.dao.BookDAO;
import com.library.dao.impl.BookDAOImpl;
import com.library.model.Book;

public class BookService {
	private final BookDAO bookDao = new BookDAOImpl();

	public void addBook(Book book) throws SQLException {
		if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
			throw new IllegalArgumentException("Book title is required");
		}
		bookDao.addBook(book);
	}

	public Book getBook(int id) throws SQLException {
		return bookDao.getBookById(id);
	}
	public List<Book> getAllBooks()throws SQLException{
		return bookDao.getAllBooks();
	}

	public void updateBook(Book book) throws SQLException {
		bookDao.updateBook(book);
	}
	
	public void deleteBook(int id)throws SQLException{
		bookDao.deleteBook(id);
	}
}