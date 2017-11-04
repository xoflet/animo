<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="cnam.nfe114.Animal;" %>
<%@ page import="cnam.nfe114.Personne;" %>
<%@ page import="cnam.nfe114.Race;" %>
<%@ page import="cnam.nfe114.Categorie;" %>

<%! 
    Animal oAnimal = new Animal();
    Personne oPerson = new Personne();
    Race oRace = new Race();
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
            <% String typeList=(String)request.getAttribute("typeList");%>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>
                <%=typeList%>
            </div>

         
            <%
            int count=0;
            if(request.getAttribute("animoList")!=null)
            {
             ArrayList al = (ArrayList)request.getAttribute("animoList");
                    Iterator itr = al.iterator();


                    while(itr.hasNext())
                    {                           
                            count++;
                            ArrayList animoList = (ArrayList)itr.next();
                            
                            oAnimal=(Animal)animoList.get(0);
                            oRace=(Race)animoList.get(1);
                            oPerson=(Personne)animoList.get(2);
                            
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
                                    <li>Tarif : <%=oAnimal.getTarif()%> Euro</li>
                                </div>
                            </ul>
                                <form target="paypal" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                                    <input type="hidden" name="cmd" value="_cart"></input>
                                    <input type="hidden" name="business" value="cletur_1293622833_biz@wanadoo.fr"></input>
                                    <input type="hidden" name="lc" value="FR"></input>
                                    <input type="hidden" name="item_name" value="<%=oAnimal.getNom()%>"></input>
                                    <input type="hidden" name="amount" value="<%=oAnimal.getTarif()%>"></input>
                                    <input type="hidden" name="currency_code" value="EUR"></input>
                                    <input type="hidden" name="button_subtype" value="products"></input>
                                    <input type="hidden" name="no_note" value="0"></input>
                                    <input type="hidden" name="tax_rate" value="19.600"></input>
                                    <input type="hidden" name="add" value="<%=oAnimal.getIdentifiant()%>"></input>
                                    <input type="hidden" name="bn" value="PP-ShopCartBF:btn_cart_LG.gif:NonHostedGuest"></input>
                                    <input type="image" src="images/cart3.bmp" name="submit" alt="PayPal - la solution de paiement en ligne la plus simple et la plus sécurisée !"></input>
                                </form>                                
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

            <%
            if(count==0)
            {
                    %>
            <div>
                <p class="details">
                <b>pas d'enregistrement trouvé</b>
                </p>
            </div>
                    <%
            }
            %>
          
          
        </div>
        <div class="clear"></div>
       
       <jsp:include page="footer.jsp" />

    </div>
</div>

</body>
</html>