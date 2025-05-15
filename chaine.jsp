<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Exercice Chaine</title>
</head>
<body>
    <%
        String bonjour = "salut la compagnie";
        String majuscules = bonjour.toUpperCase();

        String capitalise = "";
        if (bonjour != null && !bonjour.isEmpty()) {
            capitalise = bonjour.substring(0, 1).toUpperCase() + bonjour.substring(1).toLowerCase();
        }
    %>

    <h2>Chaîne originale : <%= bonjour %></h2>
    <h2>En majuscules : <%= majuscules %></h2>
    <h2>Première lettre en majuscule : <%= capitalise %></h2>
</body>
</html>
