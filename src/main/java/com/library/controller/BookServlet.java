package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private final BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new":
                    req.getRequestDispatcher("/book/add.jsp").forward(req, resp);
                    break;
                case "edit":
                    int editId = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("book", bookService.getBook(editId));
                    req.getRequestDispatcher("/book/edit.jsp").forward(req, resp);
                    break;
                case "delete":
                    bookService.deleteBook(Integer.parseInt(req.getParameter("id")));
                    resp.sendRedirect(req.getContextPath() + "/books?action=list");
                    break;
                default:
                    List<Book> books = bookService.getAllBooks();
                    System.out.println("[DEBUG] BookServlet: fetched " + books.size() + " books");
                    for (Book b : books) System.out.println("   -> " + b);
                    req.setAttribute("books", books);
                    req.getRequestDispatcher("/book/list.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            Book book = new Book(
                req.getParameter("title"),
                req.getParameter("author"),
                req.getParameter("isbn"),
                req.getParameter("category"),
                Integer.parseInt(req.getParameter("quantity")),
                Integer.parseInt(req.getParameter("availableQuantity"))
            );

            if ("update".equals(action)) {
                book.setId(Integer.parseInt(req.getParameter("id")));
                bookService.updateBook(book);
            } else {
                bookService.addBook(book);
            }
            resp.sendRedirect(req.getContextPath() + "/books?action=list");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}