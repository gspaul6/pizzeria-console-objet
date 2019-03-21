package fr.pizzeria.console;

import java.lang.reflect.Array;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;
import persistence.PizzaMemDao;
import service.*;

public class PizzeriaAdminConsoleApp {

	public static Scanner tryone = new Scanner(System.in);
   public static PizzaMemDao Napoli =new PizzaMemDao();
	

	// show the menu
	public static void showmenu() {
		submenu();
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}

	public static void submenu() {
		System.out.println("***** Pizzeria Administration *****");
	}

	public static void clearScreen() {
		// System.out.print("\033[H\033[2J");
		// System.out.flush();

		for (int i = 0; i < 10; ++i) {
			System.out.println();
		}

	}


	public static void sortirpizza() {
		clearScreen();
		submenu();
		System.out.println("Au revoir mon amor ☹");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		showmenu();
		boolean game = false;
		while (!game) {
			System.out.println("Enter your choice");
			int a = tryone.nextInt();
			switch (a) {
			case 1:
				clearScreen();
				submenu();
				ListerPizzasService tim=new ListerPizzasService();
				tim.executeUC(tryone, Napoli);
				game = true;
				break;

			case 2:
				clearScreen();
				submenu();
				AjouterPizzaService jim=new AjouterPizzaService();
				jim.executeUC(tryone, Napoli);			
				game = true;
				break;

			case 3:
				clearScreen();
				submenu();
				ModifierPizzaService lim=new ModifierPizzaService();
				lim.executeUC(tryone, Napoli);	
				game = true;
				break;

			case 4:
				clearScreen();
				submenu();
				SupprimerPizzaService mim=new SupprimerPizzaService();
				mim.executeUC(tryone, Napoli);
				game = true;
				break;

			case 99:
				clearScreen();
				submenu();
				sortirpizza();
				game = true;
				break;
			}

		}
		tryone.close();
	}

}
