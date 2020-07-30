<%--
  Created by IntelliJ IDEA.
  User: 谭海山
  Date: 2020/7/31
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>查询所有账户信息</h2>
    <c:forEach items="${list}" var="accont">
        ${accont.toString()}
    </c:forEach>
</body>
</html>
