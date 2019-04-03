package service;

import persistence.*;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService {
	public void executeUC(Scanner scanner, PizzaBddDao tim) {
		// TODO Auto-generated method stub
		List<Pizza> tomtom = tim.findAllPizzas();
        Iterator<Pizza>tom=tomtom.iterator();
        {
        	while(tom.hasNext())
        	{
        		
        		System.out.println(" "+tom.next());
        	}
        }
		System.out.println("Enter the code of the pizza you wanna delete");
		String g = scanner.next();
		// tim.deletePizza(g);
		
		
		tim.deletePizza(g.toUpperCase());
		System.out.println();
		Iterator<Pizza> itrint2 = tomtom.iterator();
		while (itrint2.hasNext()) {

			System.out.println(itrint2.next() + " ");

			
			
		}
	}
}
