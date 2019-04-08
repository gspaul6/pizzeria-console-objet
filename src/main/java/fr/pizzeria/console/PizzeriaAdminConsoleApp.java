package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.AppService;
import fr.pizzeria.model.DataAccessException;
import persistence.IPizzaDao;
import persistence.PizzaMemDao;
import service.AjouterPizzaService;
import service.ListerPizzasService;
import service.ModifierPizzaService;
import service.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	public static Scanner tryone = new Scanner(System.in);
	public static IPizzaDao Napoli = new PizzaMemDao();
	// public static IPizzaDao Napoli =new PizzaBddDao();

	// show the menu
	public static void showmenu() {
		submenu();
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("5. Save in the following in Database");
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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		new AppService().executer("hello world");
		showmenu();
		boolean game = false;
		while (!game) {
			try {

				System.out.println("Enter your choice");
				int a = tryone.nextInt();
				switch (a) {
				case 1:
					clearScreen();
					submenu();
					ListerPizzasService tim = new ListerPizzasService();
					tim.executeUC(tryone, Napoli);
					game = true;
					break;

				case 2:
					clearScreen();
					submenu();
					AjouterPizzaService jim = new AjouterPizzaService();
					jim.executeUC(tryone, Napoli);
					game = true;
					break;

				case 3:
					clearScreen();
					submenu();
					ModifierPizzaService lim = new ModifierPizzaService();
					lim.executeUC(tryone, Napoli);
					game = true;
					break;

				case 4:
					clearScreen();
					submenu();
					SupprimerPizzaService mim = new SupprimerPizzaService();
					mim.executeUC(tryone, Napoli);
					game = true;
					break;

				case 5:
					clearScreen();
					submenu();
					sortirpizza();
					game = true;
					break;

				case 99:
					clearScreen();
					submenu();
					sortirpizza();
					game = true;
					break;
				}
			} catch (DataAccessException e) {
				LOG.error(e.getMessage());
			}

		}
		tryone.close();
	}

}
