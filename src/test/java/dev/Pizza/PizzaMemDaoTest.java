package dev.Pizza;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import persistence.PizzaMemDao;

public class PizzaMemDaoTest {
	private PizzaMemDao memDao;
	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);

	@Rule
	public TestName testName;
	@Rule
	public ExpectedException exE;

	@Before
	public void init() {
		LOG.info("Etant donné, une instance de PizzaMemDao");
		memDao = new PizzaMemDao();
	}

	@Test
	public void testFindAllPizza() {
		// exE.expect(NumberFormatException.class);
		// exE.expectMessage("oops");
		LOG.info("Exécution de la method{}", testName.getMethodName());
		/*
		 * Etant Donné... Lorsque.. Alors..
		 */
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

	@Test
	public void testPizzaExists() {
		Boolean itWorks = memDao.pizzaExists("PEP");
		Assert.assertTrue(itWorks);
	}

	@Test
	public void testFindPizzaByCode() {
		Pizza p = memDao.findPizzaByCode("PEP");
		Boolean itIsAlive = memDao.pizzaExists(p.getCode());
		Assert.assertTrue(itIsAlive);
	}

}
