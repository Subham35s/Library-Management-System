package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.library.dao.BookDAO;
import com.library.model.Book;
import com.library.util.DBConnection;

public class BookDAOImpl implements BookDAO {

	@Override
	public void addBook(Book book) throws SQLException {
		String sql = "Insert into books(title, author, isbn, category, quantity, available_quantity) values(?, ?, ?, ?, ?, ?)";
		try (Connection con = DBConnection.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getIsbn());
			ps.setString(4, book.getCategory());
			ps.setInt(5, book.getQuantity());
			ps.setInt(6, book.getAvailableQuantity());
			ps.executeUpdate();
		}
	}

	@Override
	public Book getBookById(int id) throws SQLException {
		String sql = "select * from books where id = ?";
		try (Connection con = DBConnection.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return mapRow(rs);
		}
		return null;
	}

	/**
	 *
	 */
	@Override
	public List<Book> getAllBooks() throws SQLException {
		List<Book> books = new LinkedList<>();
		String sql = "select * from books order by id desc";
		try (Connection con = DBConnection.getInstance().getConnection();
				Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				books.add(mapRow(rs));
			}
		}
		return books;
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		String sql = "update books set title = ?, author = ?, isbn = ?, category = ?, quantity = ?, available_quantity = ? where id = ?";
		try (Connection con = DBConnection.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getIsbn());
			ps.setString(4, book.getCategory());
			ps.setInt(5, book.getQuantity());
			ps.setInt(6, book.getAvailableQuantity());
			ps.setInt(7, book.getId());
			ps.executeUpdate();
		}

	}

	@Override
	public void deleteBook(int id) throws SQLException {
		String sql = "delete from books where id = ?";
		try (Connection con = DBConnection.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}

	}

	private Book mapRow(ResultSet rs) throws SQLException {
		return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("isbn"),
				rs.getString("category"), rs.getInt("Quantity"), rs.getInt("available_quantity"));
	}

}
