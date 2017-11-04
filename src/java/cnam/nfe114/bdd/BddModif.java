package cnam.nfe114.bdd;

import cnam.nfe114.Personne;
import java.sql.*;

public class BddModif extends BddConnect
{
	ResultSet res;
	Statement stmt;
	
	public BddModif(String _drivers, String _url, String _user, String _pass) {
            super(_drivers,_url,_user,_pass);
	}
        public BddModif() {
            super();
	}
	
	public boolean envoiReq(String req) {
            try {
                this.stmt = this.con.createStatement();
                this.res = this.stmt.executeQuery(req);
            }catch(SQLException ex) {
                System.err.println("==>SQL Exception :\n");
                while(ex!=null)
                {
                    System.out.println("Message: "+ ex.getMessage());
                    System.out.println("SQLState: "+ ex.getSQLState());
                    System.out.println("ErrorCode: "+ ex.getErrorCode());
                    ex = ex.getNextException();
                    System.out.println("");
                    return false;
                }
            }

            return true;
			
	}
	
	public ResultSet getRS() {
            return res;
        }
	
	public boolean envoiReqUpdate(String requ)
	{
		try
		{
                    this.stmt = this.con.createStatement();
                    int x = this.stmt.executeUpdate(requ);
                    if (x > 0) {
                        this.con.commit();
                    }
                    System.out.println("Nombre de modifications apportees:"+x);
		} catch(SQLException e)
		{
                    System.err.println("==>SQL Exception :\n");
                    while(e!=null)
                    {
                            System.out.println("Message: "+ e.getMessage());
                            System.out.println("SQLState: "+ e.getSQLState());
                            System.out.println("ErrorCode: "+ e.getErrorCode());
                            e = e.getNextException();
                            System.out.println("");
                            return false;
                    }
		}
		return true;
	}

        public boolean updatePersonne(Personne person, StringBuffer msgErreur) {
            boolean okb = true;

            try {
                int id = 0, identifiant = 1;
                this.Connect();
                this.envoiReq("select max(identifiant) from PERSONNE");
                ResultSet rs = this.getRS();
                if (rs.next()) {
                   identifiant = rs.getInt(1);
                   identifiant++;
                }
                String query = "update personne set LOGIN=?, PWD=?, NOM=?, PRENOM=?, DESIGNATION=?, ADRESSE=?, CODEPOSTAL=?, VILLE=?, PAYS=?, TELEPHONE=?, TELEPHONEPORTABLE=?, EMAIL=? where IDENTIFIANT = " + person.getIdentifiant();
                PreparedStatement pstmt = this.con.prepareStatement(query);
                pstmt.setString(++id, person.getLogin());
                pstmt.setString(++id, person.getMotDePasse());
                pstmt.setString(++id, person.getNom());
                pstmt.setString(++id, person.getPrenom());
                pstmt.setString(++id, person.getDesignation());
                pstmt.setString(++id, person.getAdresse());
                pstmt.setString(++id, person.getCodePostal());
                pstmt.setString(++id, person.getVille());
                pstmt.setString(++id, person.getPays());
                pstmt.setString(++id, person.getTelephone());
                pstmt.setString(++id, person.getTelephonePortable());
                pstmt.setString(++id, person.getEmail());

                if (pstmt.executeUpdate() == 0) {
                    okb = false;
                    this.con.rollback();
                }
                else {
                    this.con.commit();
                }
                this.CloseConnect();
            } catch(SQLException e)
            {
                    System.err.println("==>SQL Exception :\n");
                    while(e!=null)
                    {
                            System.out.println("Message: "+ e.getMessage());
                            System.out.println("SQLState: "+ e.getSQLState());
                            System.out.println("ErrorCode: "+ e.getErrorCode());
                            e = e.getNextException();
                            System.out.println("");
                    }
                    okb = false;
            }
            if (okb == false) {
                msgErreur.append("Erreur à la création du compte");
            }
            return okb;
        }

         public boolean createPersonne(Personne person, StringBuffer msgErreur) {
            boolean okb = true;

            try {
                int id = 0, identifiant = 1;
                this.Connect();
                this.envoiReq("select max(identifiant) from PERSONNE");
                ResultSet rs = this.getRS();
                if (rs.next()) {
                   identifiant = rs.getInt(1);
                   identifiant++;
                }
                person.setIdentifiant(identifiant);
                String query = "insert into personne (IDENTIFIANT, LOGIN, PWD, NOM, PRENOM, DESIGNATION, ADRESSE, CODEPOSTAL, VILLE, PAYS, TELEPHONE, TELEPHONEPORTABLE, EMAIL, NOMBREDECONNEXION, DERNIERECONNEXION, SEXE, DATEDENAISSANCE)";
                query += " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ' ', '2011-01-01')";
                PreparedStatement pstmt = this.con.prepareStatement(query);
                pstmt.setInt(++id, identifiant);
                pstmt.setString(++id, person.getLogin());
                pstmt.setString(++id, person.getMotDePasse());
                pstmt.setString(++id, person.getNom());
                pstmt.setString(++id, person.getPrenom());
                pstmt.setString(++id, person.getDesignation());
                Date date;
                /*date.setTime(person.getDateDeNaissance().getTime());
                pstmt.setDate(++id, date);*/
                pstmt.setString(++id, person.getAdresse());
                pstmt.setString(++id, person.getCodePostal());
                pstmt.setString(++id, person.getVille());
                pstmt.setString(++id, person.getPays());
                pstmt.setString(++id, person.getTelephone());
                pstmt.setString(++id, person.getTelephonePortable());
                pstmt.setString(++id, person.getEmail());
                person.setNombreDeConnexion(1);
                pstmt.setInt(++id, 1);

                java.util.Date jdate = new java.util.Date();
                person.setDerniereConnexion(jdate);
                date = new java.sql.Date(jdate.getTime());
                pstmt.setDate(++id, date);

                if (pstmt.executeUpdate() == 0) {
                    okb = false;
                    this.con.rollback();
                }
                else {
                    this.con.commit();
                }
                this.CloseConnect();
            } catch(SQLException e)
            {
                    System.err.println("==>SQL Exception :\n");
                    while(e!=null)
                    {
                            System.out.println("Message: "+ e.getMessage());
                            System.out.println("SQLState: "+ e.getSQLState());
                            System.out.println("ErrorCode: "+ e.getErrorCode());
                            e = e.getNextException();
                            System.out.println("");
                    }
                    okb = false;
            }
            if (okb == false) {
                msgErreur.append("Erreur à la création du compte");
            }
            return okb;
        }

         public boolean checkPersonne(Personne person, StringBuffer msgErreur) throws SQLException {
            boolean existb = false;
            boolean checkb = true;

            try {
                this.Connect();
                this.envoiReq("SELECT identifiant FROM PERSONNE p WHERE p.LOGIN='" + person.getLogin()+ "'");
                ResultSet rs = this.getRS();
                if (rs.next()) {
                    checkb = false;
                    if (person.getIdentifiant() > 0) {
                        if (rs.getInt("identifiant") == person.getIdentifiant()) {
                            checkb = true;
                        }
                    }
                }
                this.CloseConnect();
            } catch(SQLException e)
            {
                    System.err.println("==>SQL Exception :\n");
                    while(e!=null)
                    {
                            System.out.println("Message: "+ e.getMessage());
                            System.out.println("SQLState: "+ e.getSQLState());
                            System.out.println("ErrorCode: "+ e.getErrorCode());
                            e = e.getNextException();
                            System.out.println("");
                    }
                    checkb = false;
            }
            if (checkb == false) {
                String msg = " Pseudo " + person.getLogin() + " déjà utilisé";
                msgErreur.append(msg);
                person.setLogin("");
            }
            return checkb;
        }
}
