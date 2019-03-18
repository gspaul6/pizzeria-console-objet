package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

public static Scanner tryone = new Scanner(System.in);	
public static	Pizza []array1={
			new Pizza (0,"PEP","Pépéroni" ,12.50),
			new Pizza (1,"MAR", "Margherita", 14.00),
			new Pizza (2,"REIN", "La Reine", 11.50),
			new Pizza (3, "FRO", "La 4 fromages", 12.00),
			new Pizza (4, "CAN", "La cannibale", 12.50),
			new Pizza (5, "SAV" ,"La savoyarde", 13.00),
			new Pizza (6, "ORI", "L’orientale", 13.50),
			new Pizza (7, "IND", "L’indienne", 14.00)
		};

    //show the menu
	public static void showmenu()
	{
		submenu();
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	public static void submenu()
	{
		System.out.println("***** Pizzeria Administration *****");
	}
	
	public static void clearScreen() {  
	   // System.out.print("\033[H\033[2J");  
	    //System.out.flush();  
		
		for (int i = 0; i < 20; ++i) 
			{
			System.out.println();
			}
		
	}  
public static void listerlespizza()
{
	clearScreen();
	submenu();
	for(int i=0; i<array1.length;i++)
	{
		array1[i].afficher();
	}
}

public static void addpizza()
{
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
	for(int i=0;i<array1.length;i++)
	{
		if (array1[i]==null)
		{
			array1[i]=new Pizza(codi,label,price);
			break;
		}
	}
	System.out.println("\n");
	listerlespizza();
		
	
	
}

public static void deletepizza()
{
	clearScreen();
	submenu();
}

public static void updatepizza()
{
	clearScreen();
	showmenu();
	System.out.println("which pizz you want to modify, give the id");
	int c= tryone.nextInt();
	for(int i = 0; i<array1.length; i++)
	{
		if(array1[i].equals(c))
		{
			System.out.println(array1[i]);
			System.out.println("Is this is the entry you wanna modify");
		}
	}
	
	
}

public static void sortirpizza()
{
	clearScreen();
	System.out.println("Au revoir mon amor ☹");
}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		showmenu();
        boolean game= false;
        while(!game)
        {
        	System.out.println("Enter your choice");
        	int a= tryone.nextInt();
        	switch(a)
        	{
        	case 1 :
        		listerlespizza();
        		game=true;
        		break;
        		
        	case 2 :
        		addpizza();
        		game=true;
        		break;
        		
        	case 3 :
        		updatepizza();
        		game=true;
        		break;
        		
        	case 4 :
        		deletepizza();
        		game=true;
        		break;
        		
        	case 99 :
        		sortirpizza();
        		game=true;
        		break;
        	}
        	
        }
        tryone.close();
	}

}
