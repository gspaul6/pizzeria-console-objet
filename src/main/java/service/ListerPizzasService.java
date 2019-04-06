package service;

import persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class ListerPizzasService {

	public void executeUC(Scanner scanner, IPizzaDao tim) {
		// TODO Auto-generated method stub

		List<Pizza> tomtom = tim.findAllPizzas();
        Iterator<Pizza>tom=tomtom.iterator();
        {
        	while(tom.hasNext())
        	{
        		
        		System.out.println(" "+tom.next());
        	}
        }
		
		
	}

}
