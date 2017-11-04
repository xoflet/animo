
/*  Login kiki_1293618950_per@wanadoo.fr  Mot de passe: 12345678
*   Paiement à faire à cletur_1293622833_biz@wanadoo.fr
*/

package cnam.nfe114;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class CatalogueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        // paramètres de connexion
        Connection conn = null;
        String url = "jdbc:derby://localhost:1527/";
        String dbName = "animo";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String userName = "APP";
        String password = "APP";   
        String nextJSP = "/Catalogue";

        Statement st;
        try {
                // connexion à la base
                Class.forName(driver).newInstance();

                conn = DriverManager.getConnection(url+dbName,userName,password);

                String      pSelectCat  = request.getParameter("pSelectCat");
                String      act  = request.getParameter("act");
                String      typeList="Catalogue";
                String      query;
                ArrayList   animo_list = null;
                Personne    person = (Personne) session.getAttribute("personne");

                if (act != null) {
                    typeList = (String) session.getAttribute("typeList");
                    if (act.equals("AddPanier") || act.equals("DelPanierC")) {
                        animo_list = (ArrayList) session.getAttribute("animoList");
                        int identifiant = Integer.parseInt(request.getParameter("item_id"));
                        nextJSP = "/catalogue.jsp";
                        Iterator it = animo_list.iterator();
                        while(it.hasNext())
                        {
                            Animal oAnimal;
                            oAnimal=(Animal)it.next();
                            if (oAnimal.getIdentifiant() == identifiant) {
                                if (act.equals("DelPanierC")) {
                                    person.delAnimal(oAnimal);
                                }
                                else {
                                    person.addAnimal(oAnimal);
                                }
                                break;
                            }
                        }
                    }
                    else {                        
                        if (person == null || person.hasPanier() == false) {
                            nextJSP = "/erreur.jsp";
                            session.setAttribute("msgErreur", "Votre panier est vide");
                            animo_list = (ArrayList) session.getAttribute("animoList");
                        }
                        else {
                            if (act.equals("DelPanier")) {
                                animo_list = (ArrayList) session.getAttribute("animoList");
                                int identifiant = Integer.parseInt(request.getParameter("item_id"));
                                Iterator it = animo_list.iterator();
                                while(it.hasNext())
                                {
                                    Animal oAnimal;
                                    oAnimal=(Animal)it.next();
                                    if (oAnimal.getIdentifiant() == identifiant) {
                                        person.delAnimal(oAnimal);
                                        break;
                                    }
                                }
                            }

                            if (person.hasPanier() == false) {
                                nextJSP = "/index.jsp";
                                session.removeAttribute("animoList");
                            }
                            else {
                                double total = 0;
                                double tva = 0;

                                animo_list = person.getPanier();
                                nextJSP = "/panier.jsp";
                                Iterator it = animo_list.iterator();
                                while(it.hasNext())
                                {
                                    Animal oAnimal;
                                    oAnimal=(Animal)it.next();
                                    total += oAnimal.getTarif();
                                }
                                String mnts;
                                DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.FRANCE);
                                formatter.setMaximumFractionDigits(2);
                                formatter.setMinimumFractionDigits(2);
                                mnts = formatter.format(total);
                                request.setAttribute("totalht", mnts);
                                tva = total * 0.196;
                                mnts = formatter.format(tva);
                                request.setAttribute("tva", mnts);
                                total += tva;
                                mnts = formatter.format(total);
                                request.setAttribute("totalttc", mnts);
                            }
                        }
                    }
                }
                else {
                    animo_list = new ArrayList();
                    query = "select a.identifiant, a.numeroRegistre, a.nom, a.nom_race, a.sexe, a.dateDeNaissance, a.proprietaire, a.description, a.image, a.tarif";
                    if(pSelectCat == null)
                    {
                        // recherche avancée
                        String  pNomAnimal  = request.getParameter("pRecNomAnimal");
                        String[] items = request.getParameterValues("pRecCategorie");
                        String sLstCategorie="";

                        if (items != null) {
                            for(int loopIndex = 0; loopIndex < items.length; loopIndex++){
                                sLstCategorie += "'"+items[loopIndex]+"'";
                                if (loopIndex < items.length-1){
                                    sLstCategorie+=",";
                                }
                            }
                        }
                        if (sLstCategorie.isEmpty()) {
                            if (pNomAnimal == null) {
                                pNomAnimal = "";
                            }
                            query = query + " from animal a where a.nom like'"+pNomAnimal+"%'";
                        }
                        else {
                            query = query + " from animal a, race r where a.nom_race=r.nom and r.categorie_nom IN (" + sLstCategorie +")";
                            if (pNomAnimal!=null && ! pNomAnimal.isEmpty()) {
                                query = query + " and a.nom like'"+pNomAnimal+"%'";
                            }
                        }
                    }
                    else {
                        // catalogue
                        typeList=pSelectCat;

                        query = query + " from animal a, race r where a.nom_race=r.nom and r.categorie_nom='" + pSelectCat +"'";
                    }
                    query = query + " order by nom";

                    st = conn.createStatement();
                    ResultSet  rs = st.executeQuery(query);

                    while(rs.next()) {
                        // animal
                        Animal oAnimal = new Animal();
                        oAnimal.setIdentifiant(rs.getInt("identifiant"));
                        oAnimal.setNumeroRegistre(rs.getString("numeroRegistre"));
                        oAnimal.setNom(rs.getString("nom"));
                        oAnimal.setDescription(rs.getString("description"));
                        oAnimal.setImage(rs.getString("image"));
                        oAnimal.setTarif(rs.getDouble("tarif"));
                        oAnimal.setDateDeNaissance(rs.getDate("dateDeNaissance"));
                        
                        String sex = rs.getString("sexe");
                        char i=sex.charAt(0);
                        oAnimal.setSexe(i);

                        // race
                        Race oRace = new Race();
                        oRace.setNom(rs.getString("nom_race"));
                        oAnimal.setRace(oRace);

                        Personne personne = new Personne();
                        personne.setNom(rs.getString("proprietaire"));
                        oAnimal.setProprietaire(personne);
                        animo_list.add(oAnimal);
                    }
                    nextJSP = "/catalogue.jsp";
                }

                if (animo_list.isEmpty()) {
                    if (! act.equals("DelPanier")) {
                        nextJSP = "/erreur.jsp";
                        session.setAttribute("msgErreur", "Aucun animal ne correspond à votre recherche");
                    }
                }
                else {
                    session.setAttribute("animoList", animo_list);
                    session.setAttribute("typeList", typeList);
                }
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.forward(request, response);
                conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }  
  

}
