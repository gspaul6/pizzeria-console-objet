package dev.Service;

import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import service.*;
import persistence.IPizzaDao;
import persistence.PizzaMemDao;

public class MenuServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecutedUC(){
		IPizzaDao dao=new IPizzaDao();
		MenuService.executeUC(new Scanner(System.in),dao);
	}
}
