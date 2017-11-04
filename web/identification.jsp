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

            <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title="" /></span>Inscription</div>
             <div class="identif">
               <div class="contact_form">
                <div class="form_subtitle">Créer un nouveau compte (* champ obligatoire)</div>
                 <form name="Enregistrement" action="https://localhost:8181/Animo/AnimoServlet">
                    <input type="hidden" name="act" value="enr"/>
                    <div class="form_row">
                    <label class="contact"><strong>Désignation*:</strong></label>
                    <select name="designation">
                    <option value="Mr">Monsieur</option>
                    <option value="Mme">Madame</option>
                    <option value="Mlle">Mademoiselle</option>
                    </select>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Nom*:</strong></label>
                    <input type="text" class="contact_input" name="nom"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Prénom*:</strong></label>
                    <input type="text" class="contact_input" name="prenom"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Pseudo*:</strong></label>
                    <input type="text" class="contact_input" name="pseudo"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Mot de passe*:</strong></label>
                    <input type="password" class="contact_input" name="motDePasse"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Email*:</strong></label>
                    <input type="text" class="contact_input" name="email"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Tél:</strong></label>
                    <input type="text" class="contact_input" name="tel"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Tél. portable:</strong></label>
                    <input type="text" class="contact_input" name="telp"/>
                    </div>
                     
                    <div class="form_row">
                    <label class="contact"><strong>Adresse:</strong></label>
                    <input type="text" class="contact_input" name="adresse"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Code postal:</strong></label>
                    <input type="text" class="contact_input" name="codePostal"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Ville:</strong></label>
                    <input type="text" class="contact_input" name="ville"/>
                    </div>

                    <div class="form_row">
                    <label class="contact"><strong>Pays:</strong></label>
                    <select name="pays">
                    <option value="fr">France</option>
                    <option value="de">Allemagne</option>
                    <option value="be">Belgique</option>
                    <option value="lu">Luxembourg</option>
                    <option value="ch">Suisse</option>
                    <option value="AE">Autres pays d'Europe</option>
                    <option value="HE">Autres pays hors Europe</option>
                    </select>
                    </div>

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" />
                        J'ai compris les <a href="#">termes &amp; conditions</a>
                        </div>
                    </div>


                    <div class="form_row">
                    <input type="submit" class="register" value="Créer" />
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
