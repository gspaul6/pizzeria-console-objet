package fr.pizzeria.model;




/**
 * @author gurpr
 *
 */
public class Pizza {


	private int id;
	private String code;
	private String libelle;
	private double prix;
	private static int compteur;
	
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
	public Pizza()
	{
		
	}
	
 /**
 * @param code
 * @param libelle
 * @param prix
 */
public Pizza(String code, String libelle, double prix) {
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
		Pizza.compteur+=1;
		this.id=Pizza.compteur;
		
	}

	/**
	 * constructer clic on the constructor then press shift+alt+j
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id,String code, String libelle, double prix) {
		this.id=id;
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
		
	}
	/**
	 * to show everything
	 */
	public void afficher()
	{
		System.out.println(+this.id+"|"+this.code+"|"+this.libelle+"|"+this.prix );
	}

	public String toString(){
		return this.id+"|"+this.code+"|"+this.libelle+"|"+this.prix ;
		
	}
}
