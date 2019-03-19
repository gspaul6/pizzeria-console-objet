package fr.pizzeria.console;

import java.lang.reflect.Array;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;
import persistence.PizzaMemDao;

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

	public static void listerlespizza() {
		clearScreen();
		submenu();
		Napoli.findAllPizzas();
	}

	public static void addpizza() {
		clearScreen();
		submenu();
		String codi, label;
		double price;
		System.out.println("enter three letter code");
		codi = tryone.next();
		System.out.println("enter label code");
		label = tryone.next();
		System.out.println("enter price code");
		price = tryone.nextDouble();
		Pizza Hitl=new Pizza(codi,label,price);
        Napoli.saveNewPizza(Hitl);
		System.out.println("\n");
		listerlespizza();

	}

	public static void deletepizza() {
		clearScreen();
		submenu();
		listerlespizza();
		System.out.println("Enter the code of the pizza you wanna delete");
		String g=tryone.next();
		Napoli.deletePizza(g);
		
	}

	public static void updatepizza() {
		clearScreen();
		listerlespizza();
		boolean trump = false;
		Pizza tomato=new Pizza();
		while (!trump) {
			boolean gameover = false;
			if (!gameover) {
				System.out.println("which pizz you want to modify, give the id");
				int c = tryone.nextInt();
				
				for (int i = 0; i <Napoli.findAllPizzas().length; i++) {
					if (Napoli.findAllPizzas()[i].getId()==c) {
						System.out.println(Napoli.findAllPizzas()[i].toString());
						System.out.println("Is this is the entry you wanna modify, answer yes or no to exit");
						String ans = tryone.next().toLowerCase();
						if (ans.equalsIgnoreCase("yes")) {
							listerlespizza();
									System.out.print(Napoli.findAllPizzas()[i].toString());
									System.out.println("which parameter you wanna modify");
									System.out.println();
									System.out.println("Enter 1 for code of it");

									System.out.println("Enter 2 for label of it");

									System.out.println("Enter 3 for price of it");
									System.out.println();

									int e = tryone.nextInt();
									switch (e) {
									case 1:
										System.out.println("Enter a three letter word for your code for Pizza");
										String r=tryone.next();
										
									   Napoli.updatePizza1(r,tomato);
										listerlespizza();
										sortirpizza();
										trump = true;
										gameover = true;
										break;

									case 2:
										System.out.println("Enter a label  for your Pizza");
										String s=tryone.next();
										
										   Napoli.updatePizza1(s,tomato);
										listerlespizza();
										sortirpizza();
										trump = true;
										gameover = true;
										break;

									case 3:
										System.out.println("Enter a price  for your Pizza");
										double t =tryone.nextDouble();
										
										   Napoli.updatePizza2(t,tomato);
										listerlespizza();
										sortirpizza();
										trump = true;
										gameover = true;
										break;

									}
									
						}
								
						
						 
						else if (ans == "no") {
							System.out.println("would you like to give another entry, type 1 for yes and 2 for no");
							int l = tryone.nextInt();
							switch (l) {
							case 1:
								gameover = true;
								break;
							case 2:
								sortirpizza();
								gameover = true;
								trump = true;

							}

						}
					}
				}
			}
		}

	}

	public static void sortirpizza() {
		clearScreen();
		submenu();
		System.out.println("Au revoir mon amor ☹");
	}
	
	public static void verify (Pizza []arr )
	{
		 for(int i =0;i<arr.length;i++)
		 {
			 if (arr[i].equals(null)  )
			 {
				arr[i]= new Pizza();
				break;
			 }
		 }
		 
		
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
				listerlespizza();
				game = true;
				break;

			case 2:
				addpizza();
				game = true;
				break;

			case 3:
				updatepizza();
				game = true;
				break;

			case 4:
				deletepizza();
				game = true;
				break;

			case 99:
				sortirpizza();
				game = true;
				break;
			}

		}
		tryone.close();
	}

}
