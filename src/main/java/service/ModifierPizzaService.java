package service;

import persistence.*;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class ModifierPizzaService {

	public void executeUC(Scanner scanner, PizzaBddDao tim) {
		List<Pizza> tomtom = tim.findAllPizzas();
		Iterator<Pizza> tom = tomtom.iterator();
		{
			while (tom.hasNext()) {

				System.out.println(" " + tom.next());
			}
		}

		System.out.println("Enter the code of the pizza you wanna modify");
		String g = scanner.next();
		// tim.deletePizza(g);

		tim.deletePizza(g.toUpperCase());
		String codi, label;
		String price;
		System.out.println("enter three letter code");
		codi = scanner.next();
		System.out.println("enter label");
		label = scanner.next();
		System.out.println("enter price ");
		price = scanner.next();
		double prix2 = Double.parseDouble(price);

		Pizza Hitl = new Pizza(codi, label, prix2);
		tim.updatePizza(codi,Hitl);
		System.out.println("\n");

		for (int i = 0; i < tomtom.size(); i++) {
			if (tomtom.get(i) != null) {
				System.out.println(tomtom.get(i));
			}
		}
	}

}
