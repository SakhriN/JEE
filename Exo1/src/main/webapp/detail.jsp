<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>


    <h1>Detail de l'item numéro ${detail.getId()} :</h1>

    <div><b>Marque : </b>${detail.getMarque()}</div>
    <div><b>Reference : </b>${detail.getReference()}</div>
    <div><b>Date d'achat : </b>${detail.getDateAchat()}</div>
    <div><b>Prix : </b>${detail.getPrix()} €</div>
    <div><b>Stock : </b>${detail.getStock()}</div>
</tbody>
</table>
</body>
</html>

