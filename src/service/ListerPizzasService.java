package service;
import persistence.*;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
public class ListerPizzasService {
	
	public void executeUC(Scanner scanner, PizzaMemDao tim ) {
		// TODO Auto-generated method stub
	
		tim.findAllPizzas();
	}

}
