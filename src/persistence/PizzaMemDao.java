package persistence;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	private Pizza[]pizza;
	
	public PizzaMemDao(Pizza[]array1)
	{
		array1=new Pizza[100];		
		array1[0]=new Pizza(0, "PEP", "Pépéroni", 12.50); 
		array1[1]=new Pizza(1, "MAR", "Margherita", 14.00);
		array1[2]=new Pizza(2, "REIN", "La Reine", 11.50); 
		array1[3]=new Pizza(3, "FRO", "La 4 fromages", 12.00);
		array1[4]=new Pizza(4, "CAN", "La cannibale", 12.50); 
		array1[5]=new Pizza(5, "SAV", "La savoyarde", 13.00);
		array1[6]=new Pizza(6, "ORI", "L’orientale", 13.50); 
		array1[7]=new Pizza(7, "IND", "L’indienne", 14.00); 
	    this.pizza=array1;
	}
	public PizzaMemDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Pizza[] findAllPizzas() {
		return this.pizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.pizza.length; i++)
		{
			verify(this.pizza);
			this.pizza[i] = new Pizza();
			break;
		
	}
	}

	@Override
	public void updatePizza1(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.pizza.length; i++)
		{
			if(this.pizza[i].getCode().equals(codePizza))
			{
				this.pizza[i]=pizza;
			}
			else if(this.pizza[i].getLibelle().equals(codePizza))
			{
				
				this.pizza[i]=pizza;
			}
			
			
		}
	}
	
	
	@Override
	public void updatePizza2(double price, Pizza pizza) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.pizza.length; i++){
		 if(this.pizza[i].getPrix()==price)
		{
			 this.pizza[i]=pizza;
		}
		}
	}
	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		for(int k=0; k<this.pizza.length;k++)
		{
			if(this.pizza[k].getCode().equalsIgnoreCase(codePizza))
			{
				this.pizza[k]=null;
			break;
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		for(int i = 0; i<this.pizza.length;i++)
			if(this.pizza[i].getCode().equals(codePizza))
			{
				System.out.println("The pizza you was searching for is here-->"+ this.pizza[i].toString());
			}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		boolean a=false;
		for(int i = 0; i<this.pizza.length;i++)
			{
			if(this.pizza[i].getCode().equals(codePizza))
			
			{
				System.out.println("The pizza Exists-->"+ this.pizza[i].toString());
				a= true;
			}
			else 
			{
				System.out.println("The pizza does not exists");
				a= false;
			}
	}
		return a;
		
	}
	public  void verify (Pizza []arr )
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
	
}
