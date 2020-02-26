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

    <form action="connexion" method="POST">
        <label for="pseudo"> Pseudonyme </label>
        <input type="text" dataSource="client.pseudo" id="pseudo"/><br/>
        <label for="motDePasse"> Mot de passe </label>
        <input type="password" dataSource="client.motDePasse" id="motDePasse"/>
        <input type="submit" type="submit" />
    </form>
</body>
</html>
