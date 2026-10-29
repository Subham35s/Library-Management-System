<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Member</title>
<style>
body{font-family: Arial; padding: 30px; background:  #f4f6f9;}
.form-box{max-width: 500px; margin: auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);}
input, textarea{width: 100%; padding: 10px; margin: 8px 0; border: 1px solid #ccc; border-redius: 5px; box-sizing: border-box;}
button{background: #27ae60; color: white; padding: 12px 24px; border: none;  border-radius: 5px;}
label{font-weight: bold,cok }	
</style>
</head>
<body>
	<div class="form-box">
	<h2>Add New Member</h2>
	<form action="members" method="post">
	<label>Name</label>
	<input type="text" name="name" required>
	
	<label>Email</label>
	<input type="email" name="email" required>
	
	<label>Phone</label>
	<input type="text" name="phone">
	
	<label>Address</label>
	<textarea name="address" rows="3"></textarea>
	
	<br><br>
	<button type="submit">Save Member</button>
	<a href="members?action=list">Cancel</a>
	</form>
	</div>
</body>
</html>