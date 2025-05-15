<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<html>
<head>
    <title>Manipulation de chaîne</title>
</head>
<body bgcolor="white">
<h1>Manipulation de chaîne</h1>

<%! 
    public class ChaineUtils {
        public static String mettreEnMajuscules(String texte) {
            return texte.toUpperCase();
        }

        public static String majusculeInitiale(String texte) {
            if (texte == null || texte.isEmpty()) return texte;
            return texte.substring(0, 1).toUpperCase() + texte.substring(1);
        }
    }
%>

<%
    String texte = "salut la compagnie";
    String majuscules = ChaineUtils.mettreEnMajuscules(texte);
    String initMajuscule = ChaineUtils.majusculeInitiale(texte);

    out.println("<b>Texte original :</b> " + texte + "<br>");
    out.println("<b>En majuscules :</b> " + majuscules + "<br>");
    out.println("<b>Initiale en majuscule :</b> " + initMajuscule + "<br>");
%>

</body>
</html>
 
