
package cnam.nfe114;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.*;


/**
 *
 * @Stateless
 */
@Stateless
public class Categorie {

	private String nom;
	private String image;
	private String description;

        public Categorie() {
        }

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

        public List<Categorie> findAll() {
            // <editor-fold defaultstate="collapsed" desc="comment">
            List<Categorie> lst = new ArrayList<Categorie>();
            try {
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/animo", "APP", "APP");
                ResultSet rs = conn.createStatement().executeQuery("select * from categorie");
                while (rs.next()) {
                    Categorie c = new Categorie();
                    c.setNom(rs.getString("nom"));
                    c.setImage(rs.getString("image"));
                    c.setDescription(rs.getString("description"));
                    lst.add(c);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Categorie.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lst;
        }

}