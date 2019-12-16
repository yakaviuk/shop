<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All available goods</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Country</th>
        <th>Image</th>
    </tr>
    <c:forEach var="goods" items="${goodsList}">
        <tr>
            <td>${goods.goodsName}</td>
            <td>${goods.goodsPrice}</td>
            <td>${goods.description}</td>
            <td>${goods.country}</td>
            <td>${goods.goodsImage}</td>
            <td><a href="/delete/${goods.id}">Delete this item</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/add-new-goods">Add new goods</a>
</body>
</html>