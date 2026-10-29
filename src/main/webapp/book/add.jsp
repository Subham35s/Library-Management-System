<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<style>
	body{font-family: Arial; padding: 30px; background: #f4f6f9;}
	.form-box{max-width: 500px; margin: auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px  10px rgba(0,0,0,0.1);}
	input,select{width: 100%; padding: 10px; margin: 8px 0; border: 1px solid #ccc; border-radius: 5px;box-sizing: border-box;}
	button{background: #27ae60; color: white; padding: 12px 24px; border: none; border-radius: 5px; cursor: pointer;}
	button:hover{background: #219150;}
	label{font-weight: bold; color: #2c3e50;}
</style>
<body>
	<div class="form-box">
	<h2>Add New Book</h2>
	<form action="books" method="post">
	
	<label>Title</label>
	<input type ="text" name= "title" required>
	
	<label>Author</label>
	<input type ="text" name = "author" required> 
	
	<label>ISBN</label>
	<input type="text" name="isbn" required>
	
	<label>Category</label>
	<input type="text" name="category">
	
	<label >Quantity</label>
	<input type="number" name="quantity" value="1" min="1" required>
	
	<label>Available Quantity</label>
	<input type="number" name="availableQuantity" value="1" min="0" required>
	<br>
	<button type="submit">Save Book</button>
	<a href="books?action=list">Cancel</a>
	
	</form>
	</div>
</body>
</html>