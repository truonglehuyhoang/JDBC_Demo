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
            <button type="submit" name="action" value="delete">Xóa Học Sinh</button>
            <button type="submit" name="action" value="add">Thêm Học Sinh</button>
            <button type="submit" name="action" value="search">Tìm Kiếm Học Sinh</button>
        </form>
        
        <c:choose>
            <c:when test="${param.action == 'list'}">
                <h2>${msg}</h2>
                <c:if test="${not empty list}">
                    <table border="1" cellpadding="5" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên</th>
                                <th>Tuổi</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="student" items="${list}">
                                <tr>
                                    <td>${student.id}</td>
                                    <td>${student.name}</td>
                                    <td>${student.age}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </c:when>
            
            <c:when test="${param.action == 'delete'}">
                <input type="hidden" name="action" value="delete">
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" required><br>
                    <button type="submit">Xóa</button>
                <form action="student" method="get">
                    
                </form>
            </c:when>
            
            <c:when test="${param.action == 'add'}">
                
            </c:when>
            
            <c:when test="${param.action == 'search'}">
                
            </c:when>
            
            <c:otherwise>
                
            </c:otherwise>
        </c:choose>
    </body>
</html>
