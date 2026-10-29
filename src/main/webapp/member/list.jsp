<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members</title>
	<style>
	body{
	font-family: Arial;
	padding: 30px;
	background: #f4f6f9;
	}
	table{width: 100%; border-collaps: collapse; background: white; box-shadow: 0 2px 8px rgba(0,0,0,0.1);}
	th,td{padding: 12px; text-align: left; border-bottom: 1px solid #eee;}
	th{background: #9b59b6; color: white;}
	.btn{padding: 8px 14px; text-decoration: none; border-redius: 4px; color: white;}
	.add{background: #27ae60;}
	.edit{background: #f39c12;}
	.delete{background: #e74c3c;}
	.back{background: #7f8c8d; margin-left: 10px;}
	</style>
</head>
<body>
	<h2>👥 Members List</h2>
	<a href="members?action=new" class="btn add">+ Add New Member</a>
	<a href="index.jsp" class="btn back">🏠 Home</a>
	
	<br><br>
	<table>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Phone</th>
	<th>Address</th>
	<th>Actions</th>
	</tr>
	
	<c:forEach var="m" items="${members}">
		<tr>
			<td>${m.id}</td>
			<td>${m.name}</td>
			<td>${m.email}</td>
			<td>${m.phone}</td>
			<td>${m.address}</td>
			<td>
				<a href="members?action=edit&id=${m.id}" class="btn edit">Edit</a>
				<a href="members?action=delete&id=${m.id}" class="btn delete" onClick="return confirm('Delete this member?')">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>

