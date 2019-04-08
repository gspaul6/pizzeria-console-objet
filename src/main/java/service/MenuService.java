package service;

import java.util.Scanner;

import persistence.IPizzaDao;

public abstract class MenuService {
	public abstract void executeUC(Scanner scanner, IPizzaDao dao);

}
