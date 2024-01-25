<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 24/01/2024
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="form" method="post">
    <table>
    <tr>
    <td><label for="marque"> Marque : </label></td>
        <td><input type="text" name="marque" id="marque" value="${(formproduct != null) ? formproduct.getMarque() : ''}"></td>

    </tr>
    <tr>
        <td><label for="reference">Référence</label></td>
        <td><input type="text" name="reference" id="reference" value="${(formproduct!=null)?formproduct.getReference():''}"></td>
    </tr>
    <tr>
        <td><label for="date">Date d'achat</label></td>
        <td><input type="date" name="date" id="date" value="${(formproduct!=null)?formproduct.getDateAchat():''}"></td>
    </tr>
    <tr>
        <td><label for="stock">stock</label></td>
        <td><input type="text" name="stock" id="stock" value="${(formproduct!=null)?formproduct.getStock():''}"></td>
    </tr>
    <tr>
        <td><label for="prix">prix</label></td>
        <td><input type="text" name="prix" id="prix" value="${(formproduct!=null)?formproduct.getPrix() :''}"></td>
    </tr>
    </table>
    <button type="submit">${(formproduct!=null)?"Modifier" :"Créer"}</button>
</form>

</body>
</html>
