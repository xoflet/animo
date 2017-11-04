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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chris
 */
public class AnimoLogin extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AnimoLogin</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AnimoLogin at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

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
        
        String jspNames;
        String login = request.getParameter("login");
        String mdp = request.getParameter("motDePasse");
        int login_menu = Integer.parseInt(request.getParameter("login_menu"));

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Personne person = (Personne) session.getAttribute("personne");

        try {
            if (login_menu!=2 || person==null || person.getLogin() == null) {
                if (login == null || login.isEmpty()) {
                    session.setAttribute("msgErreur", "L'utilisateur est obligatoire");
                    jspNames = "erreur.jsp";
                }
                else {
                    if (person == null) {
                        person = new Personne();
                        session.setAttribute("personne", person);
                    }
                    person.setLogin(login);
                    person.setStepLogin(login_menu);
                    jspNames = "index.jsp";
                }
            }
            else {
                if (mdp == null || mdp.isEmpty()) {
                    session.setAttribute("msgErreur", "Le mot de passe est obligatoire");
                    jspNames = "erreur.jsp";
                }
                else {
                    boolean existb = false;
                    BddModif db=new BddModif();
                    db.Connect();
                    db.envoiReq("SELECT * FROM PERSONNE p WHERE p.LOGIN='"+ person.getLogin()+"' AND p.PWD='" + mdp + "'");
                    ResultSet rs = db.getRS();

                    if (rs.next()) {
                        existb = true;
                        jspNames = "index.jsp";
                        person.setIdentifiant(rs.getInt("identifiant"));
                        person.setMotDePasse(rs.getString("pwd"));
                        person.setNom(rs.getString("nom"));
                        person.setPrenom(rs.getString("prenom"));
                        person.setDesignation(rs.getString("designation"));
                        person.setSexe((rs.getString("sexe").charAt(0)));
                        person.setDateDeNaissance(rs.getDate("datedenaissance"));
                        person.setAdresse(rs.getString("adresse"));
                        person.setCodePostal(rs.getString("codepostal"));
                        person.setVille(rs.getString("ville"));
                        person.setPays(rs.getString("pays"));
                        person.setTelephone(rs.getString("telephone"));
                        person.setTelephonePortable(rs.getString("telephoneportable"));
                        person.setEmail(rs.getString("email"));
                        person.setNombreDeConnexion(rs.getInt("nombredeconnexion"));
                        person.incNombreDeConnexion();
                        Date today = new Date();
                        person.setDerniereConnexion(today);
                        SimpleDateFormat formatDateJour = new SimpleDateFormat("yyyy-MM-dd");
                        String dateFormatee = formatDateJour.format(today);
                        //Update person
                        db.envoiReqUpdate("UPDATE PERSONNE set nombredeconnexion = " + person.getNombreDeConnexion() +
                                            " , derniereconnexion = '" + dateFormatee + "'" +
                                            " where identifiant =" + person.getIdentifiant());
                       person.setStepLogin(2);
                    }
                    else {
                        session.setAttribute("msgErreur", "Utilisateur inconnu ou mot de passe erroné");
                        session.removeAttribute("personne");
                        person = new Personne();
                        session.setAttribute("personne", person);
                        jspNames = "erreur.jsp";
                    }
                    db.CloseConnect();
                }
            }
             jspNames = "http://localhost:8080/Animo/" + jspNames;
             response.sendRedirect(response.encodeRedirectURL(jspNames));

        } catch (SQLException ex) {
            Logger.getLogger(AnimoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
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
        processRequest(request, response);
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
