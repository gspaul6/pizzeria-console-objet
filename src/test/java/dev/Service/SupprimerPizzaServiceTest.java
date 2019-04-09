package dev.Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
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
import service.SupprimerPizzaService;

public class SupprimerPizzaServiceTest {
	private IPizzaDao mem_dao;
	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Before
	public void init() {
		LOG.info("Etant donné, une instance de PizzaMemDao");
		mem_dao = new PizzaMemDao();
	}

	@Test
	public void testSupprimerPizzaService() {
		systemInMock.provideLines("PEP");

		SupprimerPizzaService adding = new SupprimerPizzaService();
		Scanner scan = new Scanner(System.in);
		adding.executeUC(scan, mem_dao);
		Pizza p = mem_dao.findPizzaByCode("PEP");

		Boolean itExist = mem_dao.pizzaExists(p.getCode());
		Assert.assertFalse(itExist);
	}

	@Test
	public void testing_delete_function() {
		IPizzaDao dao1 = Mockito.mock(IPizzaDao.class);

		// définir comportement du mock
		LOG.info("Etant donné, une instance de Pizza");
		Pizza pizza = new Pizza(1, "IOP", "yoplay", 12.0, CategoriePizza.SANS_VIANDE);

		// étant donné la saisie utilisateur suivante
		LOG.info("Etant donné, une instance de Mocker");
		systemInMock.provideLines("IOP");

		// vérifier que la méthode saveNewPizza du mock a été invoquée
		// Mockito.verify(dao1).saveNewPizza(pizza);

		Pizza delete_pizza = mem_dao.findPizzaByCode(pizza.getCode());

		SupprimerPizzaService deleting = new SupprimerPizzaService();

		deleting.executeUC(new Scanner(System.in), dao1);
		Mockito.verify(dao1).deletePizza(pizza.getCode());

	}
}
