<%--
  Created by IntelliJ IDEA.
  User: Kelvin
  Date: 2017/3/20
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <p> ${user.id} ===== ${user.name} </p>
</c:forEach>
</body>
</html>
