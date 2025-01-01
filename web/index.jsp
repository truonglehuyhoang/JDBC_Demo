<%-- 
    Document   : index
    Created on : Jan 1, 2025, 9:49:59 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL - EL</title>
    </head>
    <body>
        <h1>Quản Lý Học Sinh</h1>
        
        <form action="student" method="get">
            <button type="submit" name="action" value="list">Xem Danh Sách</button>
            <button type="submit" name="action" value="add">Thêm Học Sinh</button>
            <button type="submit" name="action" value="delete">Xóa Học Sinh</button>
            <button type="submit" name="action" value="search">Tìm Kiếm Học Sinh</button>
        </form>
    </body>
</html>
