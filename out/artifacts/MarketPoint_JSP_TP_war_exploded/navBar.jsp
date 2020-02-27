<%@ page import="Model.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">SuperMarket</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="<%=  (String) request.getServletContext().getAttribute("routeBase")%>">Accueil</a>
            </li>
            <% boolean islogged = (boolean) (request.getAttribute( "islogged" ) == null? false : request.getAttribute( "islogged" ));
                Client user = (Client) request.getAttribute( "user" );
                if(islogged){ %>
            <li class="nav-item active">
                <a class="nav-link" href="delog">Déconnexion</a>
            </li>
            <% if(user.isAdmin()){ %>
            <li class="nav-item active">
                <a class="nav-link" href=""> COMPTE ADMIN</a>
            </li>
            <% } %>
            <% }else{ %>
            <li class="nav-item active">
                <a class="nav-link" href="login">Connexion</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="register">Inscription</a>
            </li>
            <% } %>
        </ul>
    </div>
</nav>
<div>${errorMsg}</div>