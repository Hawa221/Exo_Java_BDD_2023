<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>

<html>
<head>
    <title>Exercice Chaine</title>
</head>
<body>
    <%
        // Déclaration de la chaîne
        String bonjour = "salut la compagnie";

        // Conversion en majuscules
        String majuscules = bonjour.toUpperCase();

        // Mise en majuscule de la première lettre
        String capitalise = "";
        if (bonjour != null && !bonjour.isEmpty()) {
            capitalise = bonjour.substring(0, 1).toUpperCase() + bonjour.substring(1);
        }
    %>

    <h2>Chaîne originale : <%= bonjour %></h2>
    <h2>En majuscules : <%= majuscules %></h2>
    <h2>Première lettre en majuscule : <%= capitalise %></h2>
</body>
</html>
