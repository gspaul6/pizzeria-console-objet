package service;
import persistence.*;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao tim ) {
		// TODO Auto-generated method stub
		
		String codi, label;
		double price;
		System.out.println("enter three letter code");
		codi = scanner.next();
		System.out.println("enter label code");
		label = scanner.next();
		System.out.println("enter price code");
		price = scanner.nextDouble();
		Pizza Hitl=new Pizza(codi,label,price);
        tim.saveNewPizza(Hitl);
		System.out.println("\n");
	}

}
