<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Main Menu</title>
    </head>
    <body>
        <h1>Voici les personnes présentes dans le projet : </h1>
        <table>
            <thead>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Age</th>
            </thead>
            <tbody>
            <c:forEach items="${persons}" var="bagarre">
                <tr>
                    <td>${bagarre.getNom()}</td>
                    <td>${bagarre.getPrenom()}</td>
                    <td>${bagarre.getAge()}</td>
                </tr>
            </c:forEach>
                <tr>
                    <td>${detail.getNom()}</td>
                    <td>${detail.getPrenom()}</td>
                    <td>${detail.getAge()}</td>
                </tr>
                <tr>
                    <td>${detail1.getNom()}</td>
                    <td>${detail1.getPrenom()}</td>
                    <td>${detail1.getAge()}</td>
                </tr>
                <tr>
                    <td>${detail2.getNom()}</td>
                    <td>${detail2.getPrenom()}</td>
                    <td>${detail2.getAge()}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>