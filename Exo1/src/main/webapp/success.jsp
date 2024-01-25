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
    <title>Commande réussie</title>
</head>
<body>
<h1>Vous Serez Redirigé Bientot dans la liste des produits</h1>

<h3>Appuyez <a href="product">ici</a> si vous ne voulez pas attendre.</h3>

<script type="text/javascript">
    setTimeout(function(){
        window.location.href = '<%= request.getContextPath() %>/product';
    }, 5000);
</script>
</body>
</html>
