<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Management System</title>
    <style>
        body { font-family: Arial; background: #f4f6f9; margin: 0; padding: 50px; text-align: center; }
        .container { max-width: 600px; margin: auto; background: white; padding: 40px; border-radius: 10px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }
        h1 { color: #2c3e50; }
        a { display: inline-block; margin: 15px; padding: 15px 30px; background: #3498db; color: white; text-decoration: none; border-radius: 5px; }
        a:hover { background: #2980b9; }
    </style>
</head>
<body>
    <div class="container">
        <h1>📚 Library Management System</h1>
        <a href="books?action=list">Manage Books</a>
        <a href="members?action=list">Manage Members</a>
    </div>
</body>
</html>