<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Zhangxq
  Date: 2016/7/16
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
<%
    try {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dictionary?useUnicode=true&characterEncoding=utf8", "root", "smj123.0");
        PreparedStatement pstmt=con.prepareStatement("SELECT * FROM post WHERE kind='骚年'");
        ResultSet resultSet=pstmt.executeQuery();
        if(resultSet.next()){
            out.print("shit");
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>
</body>
</html>
