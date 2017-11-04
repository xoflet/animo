<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cnam.nfe114.Categorie;"%>

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
                
            <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title="" /></span>Recherche</div>
             <div class="identif">
               <div class="contact_form">
                <div class="form_subtitle">Veuillez saisir des valeurs de recherche</div>
                <form name="frm" action="CatalogueServlet">

                    <div class="form_row">
                    <label class="contact"><strong>Nom :</strong></label>
                    <input type="text" class="contact_input" name="pRecNomAnimal"/>
                    </div>                 

                    <div class="form_row">
                        <label class="contact"><strong>Categories :</strong></label>
                        <select NAME="pRecCategorie" SIZE="5" MULTIPLE>
                            <logic:iterate name="lstCategorie" id="categorie" >
                                <option><bean:write name="categorie" property="nom"/></option>
                            </logic:iterate>
                       </select>
                    </div>


                    <div class="form_row">
                    <input type="submit" class="register" value="Ok" />
                    </div>
                  </form>
                </div>

             </div>


        </div>
       
        <div class="clear"></div>
       
       <jsp:include page="footer.jsp" />



    </div>
</div>

</body>
</html>