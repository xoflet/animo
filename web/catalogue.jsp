<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="cnam.nfe114.Personne;" %>
<%@ page import="cnam.nfe114.Race;" %>
<%@ page import="cnam.nfe114.Animal;" %>
<jsp:useBean id="personne" class="cnam.nfe114.Personne" scope="session"/>

<%!
    Animal oAnimal = new Animal();
    Personne oPerson = new Personne();
    Race oRace = new Race();
    public String iconeString(Animal a, Personne p)
    {
        if (p != null && p.isInPanier(a)) {
            return "images/cartV.bmp";
        }
        return "images/cart3.bmp";
    }
    public String actionString(Animal a, Personne p)
    {
        if (p != null && p.isInPanier(a)) {
            return "DelPanierC";
        }
        return "AddPanier";
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
            <% String typeList=(String)session.getAttribute("typeList");%>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>
                <%=typeList%>
            </div>

         
            <%
            if(session.getAttribute("animoList")!=null)
            {
                    ArrayList al = (ArrayList)session.getAttribute("animoList");
                    Iterator itr = al.iterator();

                    while(itr.hasNext())
                    {               
                            oAnimal = (Animal)itr.next();
                            oRace = oAnimal.getRace();
                            oPerson = oAnimal.getProprietaire();
            %>


            <div class="feat_prod_box">
                <div class="prod_img"><a href="#"><img src="<%=oAnimal.getImage()%>" width='100' height='80' alt="" title="" border="0" /></a></div>

                    <div class="prod_det_box">
                        <div class="box_top"></div>
                        <div class="box_center">
                            <div class="prod_title">
                                <%=oAnimal.getNumeroRegistre()%> <%=oAnimal.getNom()%>
                            </div>                     
                            <ul>
                                <div class="details">
                                    <li>Race : <%=oRace.getNom()%></li>
                                    <li>Sexe : <%=oAnimal.getSexe()%></li>
                                    <li>Propriétaire : <%=oPerson.getNom()%></li>
                                    <li>Description : <%=oAnimal.getDescription()%></li>
                                    <li>Date de naissance : <%=oAnimal.getDateDeNaissanceS()%></li>
                                    <li>Tarif : <%=oAnimal.getTarifs()%></li>
                                </div>
                            </ul>
                            <% if (personne.getStepLogin() == 2)
                            {
                            %>
                            <form name="panier" action="http://localhost:8080/Animo/CatalogueServlet">
                                    <input type="hidden" name="act" value="<%=actionString(oAnimal, personne)%>"></input>
                                    <input type="hidden" name="item_id" value="<%=oAnimal.getIdentifiant()%>"></input>
                                    <input type="hidden" name="item_name" value="<%=oAnimal.getNom()%>"></input>
                                    <input type="image" src="<%=iconeString(oAnimal, personne)%>" name="submit" alt=""></input>
                            </form>
                            <%
                            }
                            %>
                            <div class="clear"></div>
                        </div>
                        <div class="box_bottom"></div>
                    </div>
                    <div class="clear"></div>
            </div>
          
         
            <%

                    }
            }

            %>
          
        </div>
            
        <div class="clear"></div>
       
       <jsp:include page="footer.jsp" />

    </div>
</div>

</body>
</html>