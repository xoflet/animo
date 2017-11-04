package cnam.nfe114;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Animal {

	private int identifiant;
	private String numeroRegistre;
	private String nom;
        private char sexe;
	private Race race;
	private Date dateDeNaissance;
	private Date dateDeces;
	private String description;
        private Personne proprietaire;
        private String urlimage;
        private double tarif;

	public int getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNumeroRegistre() {
		return this.numeroRegistre;
	}

	public void setNumeroRegistre(String numeroRegistre) {
		this.numeroRegistre = numeroRegistre;
	}

	public Race getRace() {
		return this.race;
	}

	public void setRace(Race espece) {
		this.race = espece;
	}

        public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getDateDeNaissanceS() {
                DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
                return formatter.format(getDateDeNaissance());
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Date getDateDeces() {
		return this.dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
        public Personne getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Personne proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getImage() {
		return this.urlimage;
	}

	public void setImage(String url) {
		this.urlimage = url;
	}
        public double getTarif() {
		return this.tarif;
	}
        public String getTarifs() {
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.FRANCE);
            formatter.setMaximumFractionDigits(2);
            formatter.setMinimumFractionDigits(2);
            return formatter.format(getTarif());
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
}