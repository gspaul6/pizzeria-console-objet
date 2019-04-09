package dev.Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Assert;
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
import service.AjouterPizzaService;

public class AjouterPizzaServiceTest {
	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testAjouterPizzaService() {
		systemInMock.provideLines("LOL", "LOLA", "16.7", "1");
		IPizzaDao dao = new PizzaMemDao();
		AjouterPizzaService adding = new AjouterPizzaService();
		Scanner scan = new Scanner(System.in);
		adding.executeUC(scan, dao);
		Pizza p = dao.findPizzaByCode("LOL");

		Boolean itExist = dao.pizzaExists(p.getCode());
		Assert.assertTrue(itExist);
	}

	@Test
	public void testing_through_mockit() {
		IPizzaDao dao = Mockito.mock(IPizzaDao.class);

		// définir comportement du mock
		LOG.info("Etant donné, une instance de Pizza");
		Pizza pizza = new Pizza(1, "IOP", "yoplay", 12.0, CategoriePizza.SANS_VIANDE);

		// étant donné la saisie utilisateur suivante
		LOG.info("Etant donné, une instance de Mocker");
		systemInMock.provideLines("IOP", "yoplay", "12.00", "2");

		LOG.info("Etant donné, une instance de ajouterMemDao");
		AjouterPizzaService ajouterPizzasService = new AjouterPizzaService();

		ajouterPizzasService.executeUC(new Scanner(System.in), dao);

		// vérifier que la méthode saveNewPizza du mock a été invoquée
		Mockito.verify(dao).saveNewPizza(pizza);

		// Mockito.doThrow(DataAccessException.class).when(dao).saveNewPizza(pizza);
	}
}
