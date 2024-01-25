<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Produits</title>
</head>
<body>

<h1>La liste des produits : </h1>


<a href="form">Ajouter un produit</a>
<table>
    <thead>
    <th>Marque:</th>
    <th>Prix:</th>
    <th>Detail:</th>
    <th>Suppression:</th>
    <th>Edition:</th>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="bagarre">
        <tr>
            <td>${bagarre.getMarque()}</td>
            <td>${bagarre.getPrix()}</td>
            <td><a href="detail?id=${bagarre.getId()}">X</a></td>
            <td><a href="supprimer?id=${bagarre.getId()}">X</a></td>
            <td><a href="form?id=${bagarre.getId()}&edit=1">X</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>

