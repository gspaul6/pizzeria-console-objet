package dev.Pizza;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import persistence.PizzaMemDao;

public class PizzaMemDaoTest {
	PizzaMemDao memDao = new PizzaMemDao();

	@Test
	public void testFindAllPizza() {
		memDao.saveNewPizza(new Pizza(8, "POR", "Porky", 15.60, CategoriePizza.VIANDE));
		List<Pizza> oneList = memDao.findAllPizzas();
		int taille = oneList.size();
		Assert.assertEquals(taille, oneList.size());

	}

	@Test
	public void testSaveNewPizza() {
		Pizza pizza = new Pizza("POR", "Porky", 15.60, CategoriePizza.VIANDE);
		memDao.saveNewPizza(pizza);

		Boolean itExist = memDao.pizzaExists(pizza.getCode());
		Assert.assertTrue(itExist);
	}

	@Test
	public void testDeletePizza() {
		Pizza pizza = new Pizza("MED", "Meditarian", 17.80, CategoriePizza.POISSON);
		memDao.saveNewPizza(pizza);
		memDao.deletePizza(pizza.getCode());
		Boolean itNotThere = memDao.pizzaExists("MED");
		Assert.assertFalse(itNotThere);
	}

	@Test
	public void testUpdatePizza() {
		Pizza pizza = new Pizza("LUC", "Lucky", 17.60, CategoriePizza.VIANDE);

		memDao.updatePizza("PEP", pizza);
		Boolean itIsThere = memDao.pizzaExists(pizza.getCode());
		Assert.assertTrue(itIsThere);
	}

}
