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
    <title>Connexion</title>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
<div>${errorMsg}</div>
<form action="login" method="POST">
    <label for="pseudo"> Pseudonyme </label>
    <input type="text" dataSource="client.pseudo" id="pseudo" name="pseudo"/><br/>
    <label for="password"> Mot de passe </label>
    <input type="password" dataSource="client.motDePasse" id="password" name="password"/>
    <input type="submit" type="submit" />
</form>
</body>
</html>