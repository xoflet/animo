<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cnam.nfe114.Categorie;"%>

<div class="left_content">   

    <div class="left_box">

        <div class="title"><span class="title_icon"><img src="images/bullet5.gif" alt="" title="" /></span>Categories</div>

        <form name="form" action="CatalogueServlet">

            <input type="hidden" name="pSelectCat"/>
            <ul class="list">

                <logic:iterate name="lstCategorie" id="categorie" >
                    <li><a href="#" onclick="document.forms.form.pSelectCat.value='<bean:write name="categorie" property="nom"/>';document.forms.form.submit();"><bean:write name="categorie" property="nom"/> </a></li>
                </logic:iterate>
            </ul>
        </form>

        <div class="title"><span class="title_icon"><img src="images/bullet5.gif" alt="" title="" /></span>Menu</div>
            <ul class="list">
                <li><a href="#">Forum</a></li>
                <li><a href="#">Newsletter</a></li>
                <li><a href="#">Fiches techniques</a></li>
                <li><a href="#">Quizz</a></li>
                <li><a href="#">Le coin des passionés</a></li>
            </ul>

     </div>

</div>

