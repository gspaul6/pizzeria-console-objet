package dev.Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import persistence.IPizzaDao;
import persistence.PizzaMemDao;
import service.ModifierPizzaService;

public class ModifierPizzaServicetest {
	private IPizzaDao mem_dao;
	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	// @Before
	// public void init() {
	// LOG.info("Etant donné, une instance de PizzaMemDao");
	// mem_dao = new PizzaMemDao();
	// }

	// @Test
	// public void testModifierPizzaService() {
	// systemInMock.provideLines("PEP", "LOL", "LOLA", "16.7", "1");
	//
	// ModifierPizzaService adding = new ModifierPizzaService();
	// Scanner scan = new Scanner(System.in);
	// adding.executeUC(scan, mem_dao);
	// Pizza p = mem_dao.findPizzaByCode("LOL");
	//
	// Boolean itExist = mem_dao.pizzaExists(p.getCode());
	// Assert.assertTrue(itExist);
	// }

	@Test
	public void test_modifier_function() {
		IPizzaDao dao1 = Mockito.mock(IPizzaDao.class);

		// définir comportement du mock
		LOG.info("Etant donné, une instance de Pizza");
		Pizza pizza = new Pizza("IOP", "yoplay", 12.0, CategoriePizza.SANS_VIANDE);

		// étant donné la saisie utilisateur suivante
		LOG.info("Etant donné, une instance de Mocker");
		systemInMock.provideLines("FRO", "IOP", "yoplay", "12.0", "2");

		Mockito.when(dao1.pizzaExists("FRO")).thenReturn(true);

		ModifierPizzaService update_function = new ModifierPizzaService();

		update_function.executeUC(new Scanner(System.in), dao1);
		Mockito.verify(dao1).updatePizza("FRO", pizza);

	}
}
