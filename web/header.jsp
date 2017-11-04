<jsp:useBean id="personne" class="cnam.nfe114.Personne" scope="session"/>
<%
int steplogin = (int) personne.getStepLogin();
boolean bpanier = personne.hasPanier();
%>

    <div class="header">
        <div class="logo"><a href="http://localhost:8080/Animo/AnimalServlet"><img src="images/logo.gif" alt="" title="MOI" border="0" /></a></div>
        <div id="menu">
            <ul>
            <li class="selected"><a href="http://localhost:8080/Animo/AnimalServlet?act=Accueil">Accueil</a></li>
            <li class="divider"></li>
            <li><a href="#">Qui sommes-nous</a></li>
            <li class="divider"></li>
            <li><a href="AnimoSearch">Recherche</a></li>
            <li class="divider"></li>

        <!--login-->
        <% if(steplogin!=2) {
            if(steplogin!=1) {
        %>
            <li>
                <form name="Login" action="https://localhost:8181/Animo/AnimoLogin">
                    <input type="hidden" name="login_menu" value="1"/>
                    <input type="submit" class="login_btn" value="ok" />
                    <input type="text" class="login_input" name="login"/>
                    <label class="login_input"></label>
                </form>
            </li>
            <% } else
                {
            %>
            <li>
                <form name="Login" action="https://localhost:8181/Animo/AnimoLogin">
                    <input type="hidden" name="login_menu" value="2"/>
                    <input type="submit" class="login_btn" value="ok" />
                    <input type="password" class="login_input" name="motDePasse"/>
                    <label class="pwd_input"></label>
                </form>
            </li>
            <%
                }
            %>
            <li class="divider_right"></li>
            <li class="identif"><a  href="http://localhost:8080/Animo/AnimoServlet?act=new">Inscription</a></li>
            
        <% } else
            {
        %>

                <!--logon-->
                <li class="login"><a href="https://localhost:8181/Animo/AnimoServlet?act=compte">Bonjour <%=personne.getDesignation()%> <%=personne.getNom()%></a></li>
                <li class="divider_right"></li>
                <li class="identif"><a href="http://localhost:8080/Animo/AnimoServlet?act=logout">Deconnexion</a></li>

        <%
            }
        %>
        <% if (bpanier == true) {
        %>
        <li class="panier_btn"><a href="http://localhost:8080/Animo/CatalogueServlet?act=Panier">Panier</a></li>


        <%
            }
        %>
        </ul>
    </div>
</div>
  