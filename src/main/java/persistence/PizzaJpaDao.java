package persistence;

import java.util.List;
import javax.persistence.*;

import java.util.*;
import fr.pizzeria.model.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.loader.plan.spi.CompositeQuerySpace;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PizzaJpaDao implements IPizzaDao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");

	private EntityManager openConnection() {
		// Début d'une unité de travail
		return emf.createEntityManager();
	}

	private void closeConnection(EntityManager em) {
		em.close();
	}
     
	public void closeFactory(){
		emf.close();
	}
	@Override
	public List<Pizza> findAllPizzas() {

		List<Pizza> listPizza = new ArrayList<>();

		EntityManager em1 = this.openConnection();
		EntityTransaction transaction = em1.getTransaction();
		transaction.begin();
		TypedQuery<Pizza> query = em1.createQuery("select p from Pizza p", Pizza.class);

		query.getResultList().forEach(piz -> {
			listPizza.add(piz);
		});

		transaction.commit();
		this.closeConnection(em1);

		return listPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		EntityManager em1 = this.openConnection();
		EntityTransaction transaction = em1.getTransaction();
		transaction.begin();
		Pizza newPizza = new Pizza();
		newPizza.setCode(pizza.getCode());
		newPizza.setLibelle(pizza.getLibelle());
		newPizza.setPrix(pizza.getPrix());
		newPizza.setCategorie(pizza.getCategorie());
		em1.persist(newPizza);
		transaction.commit();
		this.closeConnection(em1);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza nePizz = null;
		EntityManager em1 = this.openConnection();
		EntityTransaction transaction = em1.getTransaction();
		transaction.begin();
		if (pizzaExists(codePizza)) {
			nePizz = findPizzaByCode(codePizza);
			nePizz.setCode(pizza.getCode());
			nePizz.setLibelle(pizza.getLibelle());
			nePizz.setPrix(pizza.getPrix());
			nePizz.setCategorie(pizza.getCategorie());
			em1.merge(nePizz);
		} else {
			System.out.println("it doesnt exist");
		}
		transaction.commit();
		this.closeConnection(em1);

	}

	@Override
	public void deletePizza(String codePizza) {
		Pizza p=null;
		EntityManager em1 = this.openConnection();
		EntityTransaction transaction = em1.getTransaction();
		transaction.begin();
		p=findPizzaByCode(codePizza);
		Pizza h = em1.find(Pizza.class, p.getId());

		if (h != null){
		em1.remove(h);
		}
		transaction.commit();
		this.closeConnection(em1);
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza p = null;
		EntityManager em1 = this.openConnection();
		EntityTransaction transaction = em1.getTransaction();
		transaction.begin();
		TypedQuery<Pizza> query = em1.createQuery("select p from Pizza p where p.code=:ref", Pizza.class);
		query.setParameter("ref", codePizza);
		p = query.getSingleResult();
		transaction.commit();
		this.closeConnection(em1);
		return p;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		List<Pizza> listPizza = new ArrayList<>();
		EntityManager em1 = this.openConnection();
		EntityTransaction transaction = em1.getTransaction();
		transaction.begin();
		TypedQuery<Pizza> query = em1.createQuery("select p from Pizza p where p.code=:ref", Pizza.class);
		query.setParameter("ref", codePizza);
		listPizza = query.getResultList();
		boolean pizzIsThere;
		if (listPizza.isEmpty()) {
			pizzIsThere = false;
		} else {
			pizzIsThere = true;
		}
		transaction.commit();
		this.closeConnection(em1);
		return pizzIsThere;

	}

}
