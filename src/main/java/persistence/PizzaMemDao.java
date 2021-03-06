package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	private List<Pizza> pizza;

	public PizzaMemDao() {
		List<Pizza> array1 = new ArrayList<>();
		array1.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		array1.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		array1.add(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		array1.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		array1.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		array1.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.POISSON));
		array1.add(new Pizza(6, "ORI", "L’orientale", 13.50, CategoriePizza.VIANDE));
		array1.add(new Pizza(7, "IND", "L’indienne", 14.00, CategoriePizza.SANS_VIANDE));
		this.pizza = array1;

	}

	@Override
	public List<Pizza> findAllPizzas() {
		return this.pizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		// int i = this.pizza.lastIndexOf(this.pizza.size()-1);
		// ++i;
		pizza.setId(this.pizza.size());

		this.pizza.add(pizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// Iterator<Pizza> temp3 = this.pizza.iterator();
		// while (temp3.hasNext()) {
		// Pizza p = temp3.next();
		// if (p.getCode().equals(codePizza)){
		// //this.saveNewPizza(pizza);
		// p.setCode(pizza.getCode());
		// p.setLibelle(pizza.getLibelle());
		// p.setPrix(pizza.getPrix());
		// p.setCategorie(pizza.getCategorie());
		// }
		// }
		if (pizzaExists(codePizza)) {
			Pizza tmp = this.findPizzaByCode(codePizza);
			int i = this.pizza.indexOf(tmp);
			this.pizza.set(i, pizza);

		}

	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		Iterator<Pizza> temp3 = this.pizza.iterator();
		while (temp3.hasNext()) {
			Pizza pizza = temp3.next();
			if (pizza.getCode().equals(codePizza)) {
				temp3.remove();
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		Pizza p = new Pizza();
		for (int i = 0; i < this.pizza.size(); i++)
			if (this.pizza.get(i) != null && this.pizza.get(i).getCode().equals(codePizza)) {
				p = this.pizza.get(i);
				System.out.println("The pizza you are searching for, is here-->" + this.pizza.get(i).toString());
			}
		return p;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.pizza.size(); i++) {
			if (this.pizza.get(i).getCode().equals(codePizza)) {

				return true;

			}
		}

		return false;

	}

	@Override
	public void closeFactory() {
		// TODO Auto-generated method stub
		
	}

}
