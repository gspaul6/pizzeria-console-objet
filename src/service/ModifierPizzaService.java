package service;
import persistence.*;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
public class ModifierPizzaService {
	
	public void executeUC(Scanner scanner, PizzaMemDao tim ) {
		// TODO Auto-generated method stub
		boolean trump = false;
		Pizza tomato=new Pizza();
		while (!trump) {
			boolean gameover = false;
			if (!gameover) {
				System.out.println("which pizz you want to modify, give the id");
				int c = scanner.nextInt();
				
				for (int i = 0; i <tim.findAllPizzas().length; i++) {
					if (tim.findAllPizzas()[i].getId()==c) {
						System.out.println(tim.findAllPizzas()[i].toString());
						System.out.println("Is this is the entry you wanna modify, answer yes or no to exit");
						String ans = scanner.next().toLowerCase();
						if (ans.equalsIgnoreCase("yes")) {
							tim.findAllPizzas();
									System.out.print(tim.findAllPizzas()[i].toString());
									System.out.println("which parameter you wanna modify");
									System.out.println();
									System.out.println("Enter 1 for code of it");

									System.out.println("Enter 2 for label of it");

									System.out.println("Enter 3 for price of it");
									System.out.println();

									int e = scanner.nextInt();
									switch (e) {
									case 1:
										System.out.println("Enter a three letter word for your code for Pizza");
										String r=scanner.next();
										
									   tim.updatePizza1(r,tomato);
										tim.findAllPizzas();
										//sortirpizza();
										trump = true;
										gameover = true;
										break;

									case 2:
										System.out.println("Enter a label  for your Pizza");
										String s=scanner.next();
										
										   tim.updatePizza1(s,tomato);
										tim.findAllPizzas();
										//sortirpizza();
										trump = true;
										gameover = true;
										break;

									case 3:
										System.out.println("Enter a price  for your Pizza");
										double t =scanner.nextDouble();
										
										   tim.updatePizza2(t,tomato);
										tim.findAllPizzas();
									//	sortirpizza();
										trump = true;
										gameover = true;
										break;

									}
									
						}
								
						
						 
						else if (ans == "no") {
							System.out.println("would you like to give another entry, type 1 for yes and 2 for no");
							int l = scanner.nextInt();
							switch (l) {
							case 1:
								gameover = true;
								break;
							case 2:
								//sortirpizza();
								gameover = true;
								trump = true;

							}

						}
					}
				}
			}
		}

	}


}
