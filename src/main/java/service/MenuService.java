package service;

import java.util.Scanner;

import persistence.IPizzaDao;
import persistence.PizzaBddDao;
import persistence.PizzaMemDao;

public abstract class MenuService {
public abstract void executeUC(Scanner scanner, IPizzaDao dao);

}
