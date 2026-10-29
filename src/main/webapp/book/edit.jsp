<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial;
	padding: 30px;
	background: #f4f6f9;
}

.form-box {
	max-width: 500px;
	margin: auto;
	background: white;
	padding: 30px;
	border-redius: 10px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

input {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-redius: 5px;
	box-sizing: border-box
}

button {
	background: #f39c12;
	color: white;
	padding: 12px 24px;
	border: none;
	border-redius: 5px;
	cursor: pointer;
}

label {
	font-weight: bold;
	color: #2c3e50;
}
</style>

</head>
<body>
	<div class="form-box">
		<h2>Edit Books</h2>
		<form action="books" method="post">
			<input type="hidden" name="action" value="update"> <input
				type="hidden" name="id" value="${book.id}"> <label>Title</label>
			<input type="text" name="title" value="${book.title}" required>

			<label>Author</label> <input type="text" name="author"
				value="${book.author}" required> <label>ISBN</label> <input
				type="text" name="isbn" value="${book.isbn}" required> <label>Category</label>
			<input type="text" name="category" value="${book.category}" required>

			<label>Quantity</label> <input type="number" name="quantity"
				value="${book.quantity}" min="1" required> <label>Available
				Quantity</label> <input type="number" name="availableQuantity"
				value="${book.availableQuantity}" min="1" required> <br>
			<br>
			<button type="submit">Update Book</button>
			<a href="books?action=list">Cancel</a>
		</form>
	</div>
</body>
</html>