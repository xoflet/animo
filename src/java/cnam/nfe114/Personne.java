package cnam.nfe114;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Personne {

	private int identifiant;
	private String login;
	private String motDePasse;
        private String designation;
	private String nom;
	private String prenom;
        private char sexe;
	private Date dateDeNaissance;
	private String adresse;
	private String codePostal;
	private String ville;
	private String pays;
	private String telephone;
	private String telephonePortable;
        private String email;
	private int nombreDeConnexion = 1;
	private Date derniereConnexion;
        private int steplogin;
        private ArrayList panier;

	public int getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getLogin() {
            if (this.login==null ||
                    this.login.isEmpty()) {
                return "";
            }

            return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}  

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
 
	public String getMotDePasse() {
		return this.motDePasse;
	}

        public boolean checkMotDePasse(String motDePasse) {
		return this.motDePasse.equals(motDePasse);
	}

	public String getNom() {
		return this.nom;
	}

        public void setDesignation(String designation) {
                this.designation = designation;
	}

	public String getDesignation() {
                return this.designation;
	}
         public Number getDesignationIndex() {
            if (this.designation == null) {
                return 1;
            }
            else if (this.designation.equals("Mr")) {
                return 1;
            }
            else if (this.designation.equals("Mme")) {
                return 2;
            }
            else if (this.designation.equals("Mlle")) {
                return 3;
            }
            else {
                return 1;
            }
        }

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public char getSexe() {
		return this.sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getPays() {
		return this.pays;
	}

        public Number getPaysIndex() {
            if (this.pays == null) {
                return 1;
            }
            else if (this.pays.equals("fr")) {
                return 1;
            }
            else if (this.pays.equals("be")) {
                return 2;
            }
            else if (this.pays.equals("lu")) {
                return 3;
            }
            else if (this.pays.equals("ch")) {
                return 4;
            }
            else if (this.pays.equals("ch")) {
                return 4;
            }
            else if (this.pays.equals("AE")) {
                return 5;
            }
            else if (this.pays.equals("HE")) {
                return 6;
            }
            else {
                return 1;
            }
        }

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephonePortable() {
		return this.telephonePortable;
	}

	public void setTelephonePortable(String telephonePortable) {
		this.telephonePortable = telephonePortable;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNombreDeConnexion() {
		return this.nombreDeConnexion;
	}

	public void setNombreDeConnexion(int nombreDeConnexion) {
		this.nombreDeConnexion = nombreDeConnexion;
	}


	public void incNombreDeConnexion() {
		this.nombreDeConnexion++;
	}

	public Date getDerniereConnexion() {
		return this.derniereConnexion;
	}

	public void setDerniereConnexion(Date derniereConnexion) {
		this.derniereConnexion = derniereConnexion;
	}

        public int getStepLogin() {
		return this.steplogin;
	}

	public void setStepLogin(int steplog) {
		this.steplogin = steplog;
	}

        public void addAnimal(Animal a) {
		if (panier == null) {
                    panier = new ArrayList();
                }
                panier.add(a);
	}
        private Animal getAnimal(int id) {
            Animal a;
            if (panier != null) {
                Iterator it = panier.iterator();
                while(it.hasNext())
                {
                    a =(Animal)it.next();
                    if (a.getIdentifiant() == id) {
                        return a;
                    }
                }
            }

            return null;
        }
        public void delAnimal(Animal animal) {
            Animal a;

            a = getAnimal(animal.getIdentifiant());
            if (a != null) {
                panier.remove(a);
                if (panier.isEmpty()) {
                    panier = null;
                }
            }
	}

        public ArrayList getPanier() {
		return this.panier;
	}

        public boolean isInPanier(Animal animal) {
                if (getAnimal(animal.getIdentifiant()) != null) {
                    return true;
                }
                return false;
	}

        public boolean hasPanier() {
            if (panier != null && ! panier.isEmpty()) {
                return true;
            }

            return false;
	}
}