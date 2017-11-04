/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cnam.nfe114;

import cnam.nfe114.bdd.BddModif;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chris
 */
public class AnimoServlet extends HttpServlet {
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act = request.getParameter("act");
        String n = request.getParameter("nom");
        String p = request.getParameter("prenom");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String jspNames;
        boolean modifb = false;
        boolean httpsb = false;
        boolean checkb = true;
        Personne person;
        person = (Personne) session.getAttribute("personne");
        String mdp = request.getParameter("motDePasse");
        String cmdp = request.getParameter("confMotDePasse");
        String ancMotDePasse = request.getParameter("ancMotDePasse");
        StringBuffer msgErreur = new StringBuffer("");

        try {
            if(act!= null && act.equals("modif")) {
                modifb = true;
            }
            if (act == null) {
                session.setAttribute("msgErreur", "Pas de paramètre action");
                jspNames = "erreur.jsp";
            }
            else if (modifb && mdp != null && ! mdp.equals(cmdp)) {
                session.setAttribute("msgErreur", "La confirmation du mot de passe a échoué");
                jspNames = "erreur.jsp";
            }
            else if (modifb && (ancMotDePasse == null ||
                        (! person.checkMotDePasse(ancMotDePasse))) ) {
                session.setAttribute("msgErreur", "Le mot de passe n'est pas correct");
                jspNames = "erreur.jsp";
            }
            else {
                if(act.equals("compte")) {
                    jspNames = "compte.jsp";
                    httpsb = true;
                }
                else if (act.equals("logout")) {
                     n = (String) person.getNom();
                     p = (String) person.getPrenom();
                    session.removeAttribute("personne");
                    session.invalidate();
                    jspNames = "AnimalServlet";
                }
                else {
                    if (person == null) {
                        person = new Personne();
                    }
                    String terms = request.getParameter("terms");
                    if (modifb) {
                        terms = "on";
                    }
                    if (n != null || modifb) {
                        if (modifb) {
                            n = person.getNom();
                        }
                        else {
                            person.setNom(n);
                        }
                        person.setPrenom(p);
                        person.setEmail(request.getParameter("email"));
                        person.setAdresse(request.getParameter("adresse"));
                        person.setCodePostal(request.getParameter("codePostal"));
                        person.setDesignation(request.getParameter("designation"));
                        person.setLogin(request.getParameter("pseudo"));
                        if (! modifb || (mdp != null && ! mdp.isEmpty()) ) {
                            person.setMotDePasse(mdp);
                        }
                        person.incNombreDeConnexion();
                        person.setTelephone(request.getParameter("tel"));
                        person.setTelephonePortable(request.getParameter("telp"));
                        person.setVille(request.getParameter("ville"));
                        person.setPays(request.getParameter("pays"));
                        BddModif db=new BddModif();
                        checkb = db.checkPersonne(person, msgErreur);
                        if (checkb == false) {
                           session.setAttribute("msgErreurPseudo", msgErreur.toString());
                        }
                    }
                    else {
                        person.setNom("");
                        person.setPrenom("");
                        person.setEmail( "");
                        person.setAdresse( "");
                        person.setCodePostal( "");
                        person.setDesignation("");
                        person.setLogin("");
                        person.setMotDePasse("");
                        person.incNombreDeConnexion();
                        person.setTelephone("");
                        person.setTelephonePortable("");
                        person.setVille("");
                        person.setPays("");
                    }

                    session.setAttribute("personne", person);
                    if (n==null ||
                            p==null ||
                            person.getNom().isEmpty() ||
                            person.getDesignation().isEmpty() ||
                            person.getEmail().isEmpty() ||
                            person.getLogin().isEmpty() ||
                            person.getPrenom().isEmpty() ||
                            person.getLogin().isEmpty() ||
                            terms == null ||
                            ! terms.contentEquals("on") ) {
                         if (act.equals("new")) {
                            jspNames = "identification.jsp";
                          }
                         else if (modifb) {
                            jspNames = "compte.jsp";
                            httpsb = true;
                         }
                         else {
                            jspNames = "identification_1.jsp";
                            httpsb = true;
                         }
                    }
                    else {
                        boolean writeb = false;
                        BddModif db=new BddModif();
                        if (modifb) {
                            writeb = db.updatePersonne(person, msgErreur);
                        }
                        else {
                            writeb = db.createPersonne(person, msgErreur);
                        }
                        if (writeb == true) {
                            jspNames = "index.jsp";
                        }
                        else {
                            session.setAttribute("msgErreur", msgErreur.toString());
                            jspNames = "erreur.jsp";
                        }
                        person.setStepLogin(2);
                    }
                }
            }
            if (httpsb) {
                RequestDispatcher dispatch = request.getRequestDispatcher(jspNames);
                dispatch.forward(request, response);
            }
            else {
                jspNames = "http://localhost:8080/Animo/" + jspNames;
                response.sendRedirect(response.encodeRedirectURL(jspNames));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnimoLogin.class.getName()).log(Level.SEVERE, null, ex);
            checkb = false;
        } finally {
            out.close();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Hello</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Hello at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
