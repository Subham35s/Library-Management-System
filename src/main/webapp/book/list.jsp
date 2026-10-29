<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
    <style>
        body { font-family: Arial; padding: 30px; background: #f4f6f9; }
        h2 { color: #2c3e50; }
        table { width: 100%; border-collapse: collapse; background: white; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #eee; }
        th { background: #3498db; color: white; }
        tr:hover { background: #f9f9f9; }
        .btn { padding: 8px 14px; text-decoration: none; border-radius: 4px; color: white; }
        .add { background: #27ae60; }
        .edit { background: #f39c12; }
        .delete { background: #e74c3c; }
        .back { background: #7f8c8d; margin-left: 10px; }
    </style>
</head>
<body>
    <h2>📖 Books List</h2>
    <a href="books?action=new" class="btn add">+ Add New Book</a>
    <a href="index.jsp" class="btn back">🏠 Home</a>
    <br><br>
    <table>
        <tr>
            <th>ID</th><th>Title</th><th>Author</th><th>ISBN</th>
            <th>Category</th><th>Qty</th><th>Available</th><th>Actions</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.isbn}</td>
                <td>${book.category}</td>
                <td>${book.quantity}</td>
                <td>${book.availableQuantity}</td>
                <td>
                    <a href="books?action=edit&id=${book.id}" class="btn edit">Edit</a>
                    <a href="books?action=delete&id=${book.id}" class="btn delete"
                       onclick="return confirm('Delete this book?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>