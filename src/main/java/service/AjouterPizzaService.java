package service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import persistence.IPizzaDao;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao tim) {
		// TODO Auto-generated method stub

		String codi, label;
		String price;
		System.out.println("enter three letter code");
		codi = scanner.next();
		System.out.println("enter label code");
		label = scanner.next();
		System.out.println("enter price code");
		price = scanner.next();
		double prix2 = Double.parseDouble(price);
		System.out.println("Choose a number for the categorie svp");
		System.out.println("1. Viande");
		System.out.println("2. Sans_viande");
		System.out.println("3. poisson");
		String cateChoice = scanner.next();
		Integer input1= Integer.parseInt(cateChoice);
		
		CategoriePizza cat=null;
		switch (input1) {
		case 1:
			cat=CategoriePizza.VIANDE;
			break;

		case 2:
			cat=CategoriePizza.SANS_VIANDE;
			break;
		case 3:
			cat=CategoriePizza.POISSON;
			break;
		}
		
		tim.saveNewPizza(new Pizza(codi, label, prix2, cat));
//		System.out.println("\n");
//		List<Pizza> tomtom = tim.findAllPizzas();
//
//		for (int i = 0; i < tomtom.size(); i++) {
//			if (tomtom.get(i) != null) {
//				System.out.println(tomtom.get(i));
//			}
//		}
	}

}
