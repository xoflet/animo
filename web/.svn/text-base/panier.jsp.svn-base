<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="cnam.nfe114.Personne;" %>
<%@ page import="cnam.nfe114.Race;" %>
<%@ page import="cnam.nfe114.Animal;" %>
<jsp:useBean id="personne" class="cnam.nfe114.Personne" scope="session"/>

<%!
    Animal oAnimal ;
    Race oRace;

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

        <div class="right_content"/>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>
                Votre Panier 
            </div>
    <div>
            
        <table align="center" border="0" cellpadding="0" cellspacing="0" class="cart_table">



            <%
            if(session.getAttribute("animoList")!=null)
            {
                    ArrayList al = (ArrayList)session.getAttribute("animoList");
                    Iterator itr = al.iterator();

                    while(itr.hasNext())
                    {
                            oAnimal = (Animal) itr.next();
                            oRace = oAnimal.getRace();

            %>


            <tbody><tr>
                <td ><a href="#"><img src="<%=oAnimal.getImage()%>" width='100' height='80' alt="" title="" border="0" /></a></td>
                            <td class="unitCol">
                                <a  href="http://localhost:8080/Animo/CatalogueServlet?act=DelPanier&item_id=<%=oAnimal.getIdentifiant()%>"> <img alt="Enlever du panier"  src="images/cartX.bmp"/>
                                </a>
                            </td>
                           <td class="unitCol">
                                <%=oAnimal.getNom()%>
                            </td>
                                 <td class="unitCol">
                                    <%=oAnimal.getTarifs()%>
                            </td>
            </tr></tbody>


            <%

                    }
            }

            %>
            <tbody>
            <tr>
                <td colspan="3" class="cart_total"><span class="red">TOTAL HT:</span></td>
                <td class="unitCol"><%=request.getAttribute("totalht")%></td>
            </tr>

            <tr>
                <td colspan="3" class="cart_total"><span class="red">TVA (19.6%):</span></td>
                <td class="unitCol"><%=request.getAttribute("tva")%></td>
            </tr>

            <tr>
                <td colspan="4"  class="unitCol">---------------</td>
            </tr>

            <tr>
                <td colspan="3" class="cart_total"><span class="red">TOTAL TTC:</span></td>
                <td class="unitCol"><%=request.getAttribute("totalttc")%></td>
            </tr>
            </tbody>
        </table>
    </div>
    </div>

            <div>
                <form class="right_footer" action="https://www.sandbox.paypal.com/fr/cgi-bin/webscr" method="post">
                    <input type="hidden" name="cmd" value="_cart"/>
                    <input type="hidden" name="upload" value="1"/>
                    <input type="hidden" name="no_shipping" value="1"/>
                    <input type="hidden" name="tax" value="19.600"/>
                    <input type="hidden" name="lc" value="FR"/>
                    <input type="hidden" name="business" value="cletur_1293622833_biz@wanadoo.fr"/>
                    <input type="hidden" name="email" value="kiki_1293618950_per@wanadoo.fr"/>
                    <input type="hidden" name="currency_code" value="EUR"/>
                    <input type="hidden" name="cancel_return" value="http://localhost:8080/Animo/CatalogueServlet?act=Panier"/>
                    <%
                        if(session.getAttribute("animoList")!=null)
                        {
                                ArrayList al = (ArrayList)session.getAttribute("animoList");
                                Iterator itr = al.iterator();
                                int     ind = 0;

                                while(itr.hasNext())
                                {
                                        oAnimal = (Animal) itr.next();
                                        ind++;

                    %>
                    <input type="hidden" name="item_name_<%=ind%>" value="<%=oAnimal.getNom()%>"/>
                    <input type="hidden" name="amount_<%=ind%>" value="<%=oAnimal.getTarif()%>"/>
                    <%

                                }
                        }
                    %>
                    <input type="image" src="https://www.paypal.com/fr_FR/FR/i/btn/btn_buynowCC_LG.gif" name="submit" alt="Effectuez vos paiements via PayPal : une solution rapide, gratuite et sécurisée"/>
</form>

             
            </div>
        <div class="clear"></div>

        <div><a target="_blank"
                    class="left_footer"
                    href="https://www.sandbox.paypal.com/fr/cgi-bin/merchantpaymentweb?cmd=xpt/Merchant/popup/WaxAboutPaypal-outside"
                    onClick="PAYPAL.core.openWindow(event,{height:500, width: 450});">
                    <img border="0" src="https://www.sandbox.paypal.com/MERCHANTPAYMENTWEB-640-20101108-1/fr_FR/i/logo/pp_secure_213wx37h.gif"
                     alt="Paiements via PayPal"/></a>
            </div>

       <jsp:include page="footer.jsp" />

    </div>

</body>
</html>