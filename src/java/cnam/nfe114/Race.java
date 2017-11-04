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
public class Race {

	private String nom;
	private Categorie categorie;
	private String image;
	private String description;

        public Race() {
        }

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
        public List<Race> findAll() {
            // <editor-fold defaultstate="collapsed" desc="comment">
            List<Race> lst = new ArrayList<Race>();
            try {
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/animo", "APP", "APP");
                ResultSet rs = conn.createStatement().executeQuery("select * from race, categorie where race.nom_categorie=categorie.nom");
                while (rs.next()) {
                    Race r = new Race();
                    Categorie c = new Categorie();
                    r.setNom(rs.getString("race.nom"));
                    r.setImage(rs.getString("race.image"));
                    r.setDescription(rs.getString("race.description"));
                    c.setNom(rs.getString("categorie.nom"));
                    c.setImage(rs.getString("categorie.image"));
                    c.setDescription(rs.getString("categorie.description"));
                    r.setCategorie(c);
                    lst.add(r);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Categorie.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lst;
        }

}