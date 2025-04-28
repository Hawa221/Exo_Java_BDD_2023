<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Ajouter une tâche</title>
</head>
<body>
    <h1>Saisir une tâche</h1>
    <form action="ajouterTache" method="post">
        <label for="inputTitre">Titre de la tâche:</label>
        <input type="text" id="inputTitre" name="titre" required>
        <label for="inputDescription">Description de la tâche:</label>
        <input type="text" id="inputDescription" name="description" required>
        <input type="submit" value="Ajouter la tâche">
    </form>

    <h2>Liste des tâches :</h2>
    <ul>
        <c:forEach var="tache" items="${sessionScope.taches}">
            <li>${tache.titre} - ${tache.description}</li>
        </c:forEach>
    </ul>
</body>
</html>
