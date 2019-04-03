package service;

import java.util.Scanner;

import persistence.PizzaMemDao;

public abstract class MenuService {
public abstract void executeUC(Scanner scanner, PizzaMemDao dao);

}
