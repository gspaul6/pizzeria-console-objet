package service;

import persistence.*;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

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
		System.out.println("Choose a number fopr the categorie svp");
		System.out.println("1. Viande");
		System.out.println("2. Sans_viande");
		System.out.println("3. poisson");
		int input1 = scanner.nextInt();
		Pizza Hitl;
		switch (input1) {
		case 1:
			Hitl = new Pizza(codi, label, prix2, CategoriePizza.VIANDE);
			tim.saveNewPizza(Hitl);
			break;

		case 2:
			Hitl = new Pizza(codi, label, prix2, CategoriePizza.SANS_VIANDE);
			tim.saveNewPizza(Hitl);
			break;
		case 3:
			Hitl = new Pizza(codi, label, prix2, CategoriePizza.POISSON);
			tim.saveNewPizza(Hitl);
			break;
		}

		System.out.println("\n");
		List<Pizza> tomtom = tim.findAllPizzas();

		for (int i = 0; i < tomtom.size(); i++) {
			if (tomtom.get(i) != null) {
				System.out.println(tomtom.get(i));
			}
		}
	}

}
