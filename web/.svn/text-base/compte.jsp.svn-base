<jsp:useBean id="personne" class="cnam.nfe114.Personne" scope="session"/>
<%!
public String isSelected(String invals, String testVals)
    {
        if (invals!=null && invals.equals(testVals)) {
            return "selected=\"selected\"";
        }
        return "";
    }
public String isEmpty(String invals)
    {
        if (invals!=null && invals.isEmpty()) {
            return "form_row_null";
        }
        return "contact_input";
    }
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<title>Animo</title>
<link rel="stylesheet" type="text/css" href="style.css" />

</head>
<body>
<div id="wrap">

    <jsp:include page="header.jsp" />

    <div class="center_content">

        <jsp:include page="leftcontent.jsp" />

        <div class="right_content">

            <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title="" /></span>Mon compte</div>
             <div class="identif">
               <div class="contact_form">
                <div class="form_subtitle">Modifier votre compte (* champ obligatoire)</div>
                 <form name="Enregistrement" action="https://localhost:8181/Animo/AnimoServlet">
                    <input type="hidden" name="act" value="modif"/>
                    <div class="form_row">
                    <label class="contact"><strong>Désignation*:</strong></label>
                    <select name="designation">
                    <option value="Mr" <%= isSelected(personne.getDesignation(), "Mr")%> >Monsieur</option>
                    <option value="Mme" <%= isSelected(personne.getDesignation(), "Mme")%> >Madame</option>
                    <option value="Mlle" <%= isSelected(personne.getDesignation(), "Mlle")%> >Mademoiselle</option>
                    </select>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Prénom*:</strong></label>
                    <input type="text" class=" <%= isEmpty(personne.getPrenom()) %> "  name="prenom" value="<%= personne.getPrenom() %>" />
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Pseudo*:</strong></label>
                    <input type="text" class=" <%= isEmpty(personne.getLogin()) %> "  name="pseudo" value="<%= personne.getLogin() %>" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Mot de passe*:</strong></label>
                    <input type="password" class="form_row_null" name="ancMotDePasse"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Nouveau mot de passe:</strong></label>
                    <input type="password" class="contact_input" name="motDePasse"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Confirmer:</strong></label>
                    <input type="password" class="contact_input" name="confMotDePasse"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Email*:</strong></label>
                    <input type="text" class=" <%= isEmpty(personne.getEmail()) %> " name="email"  value="<%= personne.getEmail() %>" />
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Tél:</strong></label>
                    <input type="text" class="contact_input" name="tel"  value="<%= personne.getTelephone() %>" />
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Tél. portable:</strong></label>
                    <input type="text" class="contact_input" name="telp"  value="<%= personne.getTelephonePortable() %>" />
                    </div>
                     
                    <div class="form_row">
                    <label class="contact"><strong>Adresse:</strong></label>
                    <input type="text" class="contact_input" name="adresse" value="<%= personne.getAdresse() %>" />
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Code postal:</strong></label>
                    <input type="text" class="contact_input" name="codePostal" value="<%= personne.getCodePostal() %>" />
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Ville:</strong></label>
                    <input type="text" class="contact_input" name="ville"  value="<%= personne.getVille() %>" />
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Pays:</strong></label>
                    <select name="pays" >
                    <option value="fr" <%= isSelected(personne.getPays(), "fr")%> >France</option>
                    <option value="de" <%= isSelected(personne.getPays(), "de")%> >Allemagne</option>
                    <option value="be" <%= isSelected(personne.getPays(), "be")%> >Belgique</option>
                    <option value="lu" <%= isSelected(personne.getPays(), "lu")%> >Luxembourg</option>
                    <option value="ch" <%= isSelected(personne.getPays(), "ch")%> >Suisse</option>
                    <option value="AE" <%= isSelected(personne.getPays(), "AE")%> >Autres pays d'Europe</option>
                    <option value="HE" <%= isSelected(personne.getPays(), "HE")%> >Autres pays hors Europe</option>
                    </select>
                    </div>

                    <div class="form_row">
                    <input type="submit" class="register" value="Valider" />
                    </div>
                  </form>
                </div>

             </div>


        </div>

        <div class="clear"></div>
       </div>


      <jsp:include page="footer.jsp" />


</div>

</body>
</html>
