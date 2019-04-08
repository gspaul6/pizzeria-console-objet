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
import service.ModifierPizzaService;

public class ModifierPizzaServicetest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testModifierPizzaService() {
		systemInMock.provideLines("PEP", "LOL", "LOLA", "16.7", "1");
		IPizzaDao dao = new PizzaMemDao();
		ModifierPizzaService adding = new ModifierPizzaService();
		Scanner scan = new Scanner(System.in);
		adding.executeUC(scan, dao);
		Pizza p = dao.findPizzaByCode("LOL");

		Boolean itExist = dao.pizzaExists(p.getCode());
		Assert.assertTrue(itExist);
	}

}
