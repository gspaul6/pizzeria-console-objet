package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Vegetarien");
	
	private String nom;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	private CategoriePizza(String nom){
		this.setNom(nom);
	}

}
