<%@ page import="Model.Client" %><%--
  Created by IntelliJ IDEA.
  User: Gabriel
  Date: 26/02/2020
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <a href="">Index</a>
    <% boolean islogged = (boolean) request.getAttribute( "islogged" );
        Client user = (Client) request.getAttribute( "user" );
    if(islogged){ %>
        <a href="delog">Déconnexion</a>
        <% if(user.isAdmin()){ %>
            <a href=""> COMPTE ADMIN</a>
        <% } %>
    <% }else{ %>
        <a href="login">Connexion</a><a href="register">Inscription</a>
    <% } %>
</nav>
