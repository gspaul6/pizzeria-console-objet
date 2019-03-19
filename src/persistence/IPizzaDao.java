package persistence;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	Pizza[] findAllPizzas();
	void saveNewPizza(Pizza pizza);
	void updatePizza1(String codePizza, Pizza pizza);
	void updatePizza2(double price, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
}
