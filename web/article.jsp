<%--
  Created by IntelliJ IDEA.
  User: Gabriel
  Date: 27/02/2020
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <h4>libelle : ${article.getLibelle()}</h4><br/>
    <p>Ref : ${article.getReference()}</p><br/>
    <p>CB : ${article.getCodeBarre()}</p><br/>
    <p>prixTTC : ${article.getPrixTTC()}€</p>
</div>
