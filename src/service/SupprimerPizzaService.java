package service;
import persistence.*;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService {
	public void executeUC(Scanner scanner, PizzaMemDao tim ) {
		// TODO Auto-generated method stub
		System.out.println("Enter the code of the pizza you wanna delete");
		String g=scanner.next();
		tim.deletePizza(g);
	
	}

}
