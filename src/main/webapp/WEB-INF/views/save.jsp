<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
       <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
    <li>id=<%=((Member)request.getAttribute("member")).getUsername()%></li>
    <li>id=<%=((Member)request.getAttribute("member")).getAge()%></li>
</ul>
</body>
</html>