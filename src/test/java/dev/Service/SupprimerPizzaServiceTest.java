package dev.Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.model.Pizza;
import persistence.IPizzaDao;
import persistence.PizzaMemDao;
import service.SupprimerPizzaService;

public class SupprimerPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testSupprimerPizzaService() {
		systemInMock.provideLines("PEP");
		IPizzaDao dao = new PizzaMemDao();
		SupprimerPizzaService adding = new SupprimerPizzaService();
		Scanner scan = new Scanner(System.in);
		adding.executeUC(scan, dao);
		Pizza p = dao.findPizzaByCode("PEP");

		Boolean itExist = dao.pizzaExists(p.getCode());
		Assert.assertFalse(itExist);
	}
}
