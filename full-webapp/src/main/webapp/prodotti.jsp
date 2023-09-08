<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prodotti</title>
</head>
<body>
    <h1>Lista dei prodotti</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Prezzo</th>
        </tr>
        <c:out value="${2+5}" />
        <c:forEach var="prodotto" items="${prodotti}">
            <tr>
                <td>${prodotto.id}</td>
                <td>${prodotto.nome}</td>
                <td>${prodotto.prezzo}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>