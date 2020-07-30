<%--
  Created by IntelliJ IDEA.
  User: 谭海山
  Date: 2020/7/31
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="account/findAll">测试</a>

    <h2>测试保存</h2>
    <form action="account/save" method="post">
        用户名：<input type="text" name="name">
        金额：<input type="text" name="money">
        <input type="submit" value="提交">
    </form>

    <h2>转账 -> 事务控制测试</h2>
    <form action="account/transfer" method="post">
        用户名1：<input type="text" name="name1">
        转账金额：<input type="text" name="money">
        用户名2：<input type="text" name="name2">
        <input type="submit" value="提交">
    </form>

</body>
</html>
