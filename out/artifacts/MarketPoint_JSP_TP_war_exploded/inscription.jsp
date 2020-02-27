<%--
  Created by IntelliJ IDEA.
  User: Gabriel
  Date: 26/02/2020
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
<form action="login" method="POST">
    <label for="pseudo"> nom </label>
    <input type="text" dataSource="client.nom" id="nom" name="nom"/><br/>
    <label for="password"> Prénom </label>
    <input type="text" dataSource="client.prenom" id="prenom" name="prenom"/>
    <label for="pseudo"> Pseudonyme </label>
    <input type="text" dataSource="client.pseudo" id="pseudo" name="pseudo"/><br/>
    <label for="password"> Mot de passe </label>
    <input type="password" dataSource="client.motDePasse" id="password" name="password"/>
    <input type="submit" />
</form>
</body>
</html>
