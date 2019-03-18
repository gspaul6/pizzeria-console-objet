package fr.pizzeria.model;



public class Pizza {


	private int id;
	private String code;
	private String libelle;
	private double prix;
	public static int compteur;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Pizza()
	{
		
	}

	public Pizza(String code, String libelle, double prix) {
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
		Pizza.compteur+=1;
		this.id=Pizza.compteur;
		
	}
	public Pizza(int id,String code, String libelle, double prix) {
		this.id=id;
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
		
	}
	public void afficher()
	{
		System.out.println(+this.id+"|"+this.code+"|"+this.libelle+"|"+this.prix );
	}

}
