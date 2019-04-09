package dev.Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import persistence.IPizzaDao;
import persistence.PizzaMemDao;
import service.ListerPizzasService;

public class ListerPizzaServiceTest {
	private IPizzaDao mem_dao;
	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void listing_the_pizza() {
		IPizzaDao dao1 = Mockito.mock(IPizzaDao.class);

		ListerPizzasService list_function = new ListerPizzasService();

		list_function.executeUC(new Scanner(System.in), dao1);
		Mockito.verify(dao1).findAllPizzas();
	}

}
