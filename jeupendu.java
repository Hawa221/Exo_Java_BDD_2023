<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jeu du Pendu</title>
    <style>
        .hidden { color: #ccc; }
        .incorrect { color: red; }
        .correct { color: green; }
    </style>
</head>
<body>
    <h1>Jeu du Pendu</h1>
    <h3>Devine le mot !</h3>

    <!-- Affichage du mot à deviner -->
    <p id="motADeviner"></p>

    <!-- Entrée pour proposer une lettre -->
    <input type="text" id="lettre" maxlength="1">
    <button onclick="proposerLettre()">Proposer</button>

    <h3>Lettres proposées :</h3>
    <p id="lettresProposees"></p>

    <h3>Essais restants : <span id="essaisRestants">6</span></h3>

    <h3 id="message"></h3>

    <script>
        // Liste des mots possibles
        const mots = ["javascript", "html", "css", "pendu", "jeu"];
        // Choisir un mot aléatoire
        const motADeviner = mots[Math.floor(Math.random() * mots.length)];

        let lettresDevinees = [];
        let essaisRestants = 6;

        // Fonction pour afficher le mot avec des _ pour les lettres non devinées
        function afficherMot() {
            let motAffiche = '';
            for (let i = 0; i < motADeviner.length; i++) {
                if (lettresDevinees.includes(motADeviner[i])) {
                    motAffiche += motADeviner[i];
                } else {
                    motAffiche += '_';
                }
            }
            document.getElementById('motADeviner').textContent = motAffiche;
        }

        // Fonction pour proposer une lettre
        function proposerLettre() {
            const lettre = document.getElementById('lettre').value.toLowerCase();
            if (lettre && !lettresDevinees.includes(lettre)) {
                lettresDevinees.push(lettre);
                document.getElementById('lettresProposees').textContent = lettresDevinees.join(", ");

                if (motADeviner.includes(lettre)) {
                    document.getElementById('message').textContent = "Bonne lettre !";
                    document.getElementById('message').className = "correct";
                } else {
                    essaisRestants--;
                    document.getElementById('essaisRestants').textContent = essaisRestants;
                    document.getElementById('message').textContent = "Mauvaise lettre !";
                    document.getElementById('message').className = "incorrect";
                }
            } else {
                alert("Veuillez entrer une nouvelle lettre.");
            }
            document.getElementById('lettre').value = '';

            afficherMot();

            if (essaisRestants <= 0) {
                document.getElementById('message').textContent = "Vous avez perdu ! Le mot était " + motADeviner;
            } else if (!document.getElementById('motADeviner').textContent.includes('_')) {
                document.getElementById('message').textContent = "Vous avez gagné ! Le mot est " + motADeviner;
            }
        }

        // Initialisation du jeu
        afficherMot();
    </script>
</body>
</html>
