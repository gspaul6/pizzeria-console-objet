package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

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
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	public static void clearScreen() {  
	   // System.out.print("\033[H\033[2J");  
	    //System.out.flush();  
		
	}  
public static void listerlespizza()
{
	clearScreen();
	
	for(int i=0; i<array1.length;i++)
	{
		PizzeriaAdminConsoleApp.array1[i].afficher();
	}
}

public static void addpizza()
{
	clearScreen();
	
}

public static void deletepizza()
{
	clearScreen();
	
}

public static void updatepizza()
{
	clearScreen();
	
}

public static void sortirpizza()
{
	clearScreen();
	System.out.println("Au revoir mon amor ☹");
}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tryone = new Scanner(System.in);
		
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
