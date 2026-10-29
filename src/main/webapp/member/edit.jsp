<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Member</title>
<style>
	body{font-famil: Arial; padding: 30px; background: #f4f6f9;}
	.form-box{max-width: 500px; margin: auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);}
	input, textarea{width: 100%; padding: 10px; margin: 8px 0; border: 1px solid #ccc; border-radius5px; box-sizing: border-box;}
	button{background: #f39c12; color: white; padding: 12px 24px; border: none; border-redius: 5px; curser: pointer}
	label{font-weight: bold; color: #2c3e50;}
</style>
</head>
<body>
	<div class="form-box">
	<h2>Edit Members</h2>
	<form action="members" method="post"> 
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="id" value="${member.id}">
		
		<label>Name</label>
		<input type="text" name="name" value="${member.name}" required>
		
		<label>Email</label>	
		<input type="email" name="email" value="${member.email}" required>
		
		<label>Phone</label>
		<input type="text" name="phone" value="${member.phone}" >
		
		<label>Address</label>
		<textarea name="address" row="3">${member.address}></textarea>
		
		<br><br>
		<button type="submit">Update Members</button>
		<a href="members?action=list">Cancel</a>
	</form>
	
	</div>
</body>
</html>