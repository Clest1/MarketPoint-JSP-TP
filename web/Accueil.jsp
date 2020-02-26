<%--
  Created by IntelliJ IDEA.
  User: Gabriel
  Date: 26/02/2020
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
<nav><a href="inscription.jsp">Index</a> <a href="connexion.jsp">Enregistrement</a> </nav>
<form action="connexion" method="POST">

            <label for="nom"> nom </label>
            <input type="number" dataSource="client.nom" id="nom"/>
    <input type="submit" type="submit" />
</form>
</body>
</html>
