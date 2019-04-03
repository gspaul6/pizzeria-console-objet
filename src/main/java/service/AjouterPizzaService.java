package service;
import persistence.*;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, PizzaBddDao tim ) {
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
		
		Pizza Hitl=new Pizza(codi,label,prix2);
        tim.saveNewPizza(Hitl);
		System.out.println("\n");
		List<Pizza>tomtom = tim.findAllPizzas();

		for (int i = 0; i < tomtom.size(); i++) {
			if (tomtom.get(i) != null) {
				System.out.println(tomtom.get(i));
			}
		}
	}

}
