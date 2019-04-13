
package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gurpr
 *
 */
@Entity
@Table(name = "pizzas")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "libelle")
	private String libelle;

	@Column(name = "prix")
	private double prix;

	private static int compteur;

	public static int getCompteur() {
		return compteur;
	}

	public static void setCompteur(int compteur) {
		Pizza.compteur = compteur;
	}

	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return label
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * empty
	 */
	public Pizza() {

	}

	/**
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(String code, String libelle, double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		Pizza.compteur += 1;
		this.id = Pizza.compteur;

	}

	/**
	 * constructer clic on the constructor then press shift+alt+j
	 * 
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;

	}

	public Pizza(int id, String code, String libelle, double prix, CategoriePizza cat) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = cat;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (categorie != other.categorie)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}

	public Pizza(String codi, String label, double prix2, CategoriePizza cat) {
		// TODO Auto-generated constructor stub

		this.code = codi;
		this.libelle = label;
		this.prix = prix2;
		this.categorie = cat;

		Pizza.compteur += 1;
		this.id = Pizza.compteur;
	}

	public void afficher() {
		System.out.println(+this.id + "|" + this.code + "|" + this.libelle + "|" + this.prix + "|" + this.categorie);
	}

	public String toString() {
		return this.id + "|" + this.code + "|" + this.libelle + "|" + this.prix + "|" + this.categorie;

	}

}
