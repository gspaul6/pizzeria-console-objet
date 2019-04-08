package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.model.DataAccessException;
import fr.pizzeria.model.Pizza;

public class PizzaBddDao implements IPizzaDao {
	private String url;
	private String user;
	private String pass;

	public PizzaBddDao() {
		super();
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		this.url = bundle.getString("jdbc.url");
		this.user = bundle.getString("jdbc.user");
		this.pass = bundle.getString("jdbc.pass");
	}

	@Override
	public List<Pizza> findAllPizzas() {

		List<Pizza> listePizzas = new ArrayList<>();
		String jdbcUrl = "jdbc:mysql://localhost:3306/bdd_pizzeria";
		// TODO Auto-generated method stub
		try (Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");

				Statement st = uneConnexion.createStatement();

				// Etape 4 - exécution de la requête
				ResultSet rs = st.executeQuery("select * from pizza");) {

			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 - Définition de la JDBC URL

			// Etape 3 - Création de la connexion

			// Etape 5 - exploitation des résultats
			while (rs.next()) {
				int id = rs.getInt("Id");
				String code = rs.getString("codepizza");
				String label = rs.getString("libelle");
				double price = rs.getDouble("prix");

				listePizzas.add(new Pizza(id, code, label, price));

				// System.out.println("ID ->" + id + "CODE_POSTAL->" + code
				// +"|"+ " libelle = " + label +"|"+ " " + " prix = "+ price );
			}
			// Etape 6 - Fermeture des ressources

			return listePizzas;

		} catch (SQLException e) {
			throw new DataAccessException("Problème accès en base", e);
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Problème no name", e);
		}

	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub

		try {

			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 - Définition de la JDBC URL
			String jdbcUrl = "jdbc:mysql://localhost:3306/bdd_pizzeria";

			// Etape 3 - Création de la connexion
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");

			Statement st = uneConnexion.createStatement();

			PreparedStatement insertPizzaSt = uneConnexion
					.prepareStatement("INSERT INTO PIZZA(codepizza,libelle,prix) VALUES(?,?,?)");
			insertPizzaSt.setString(1, pizza.getCode());
			insertPizzaSt.setString(2, pizza.getLibelle());
			insertPizzaSt.setDouble(3, pizza.getPrix());
			insertPizzaSt.executeUpdate();

			// Etape 6 - Fermeture des ressources

			st.close();

			uneConnexion.close();

		} catch (SQLException e) {
			throw new DataAccessException("Problème accès en base", e);
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Problème no name", e);
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub

		try {

			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 - Définition de la JDBC URL
			String jdbcUrl = "jdbc:mysql://localhost:3306/bdd_pizzeria";

			// Etape 3 - Création de la connexion
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
			Statement st = uneConnexion.createStatement();

			PreparedStatement updatePizzaSt = uneConnexion
					.prepareStatement("UPDATE PIZZA SET codepizza=?,libelle=?,prix=?  where codepizza=?");
			updatePizzaSt.setString(1, pizza.getCode());
			updatePizzaSt.setString(2, pizza.getLibelle());
			updatePizzaSt.setDouble(3, pizza.getPrix());
			updatePizzaSt.setString(4, codePizza);
			updatePizzaSt.executeUpdate();

			// Etape 6 - Fermeture des ressources

			st.close();

			uneConnexion.close();

		} catch (SQLException e) {
			throw new DataAccessException("Problème accès en base", e);
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Problème no name", e);
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		Pizza pizza = new Pizza();
		try {

			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 - Définition de la JDBC URL
			String jdbcUrl = "jdbc:mysql://localhost:3306/bdd_pizzeria";

			// Etape 3 - Création de la connexion
			Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
			Statement st = uneConnexion.createStatement();
			ResultSet rs = st.executeQuery("select * from pizza");
			while (rs.next()) {
				if (codePizza == pizza.getCode() && codePizza == rs.getString("codepizza")) {
					PreparedStatement deletePizzaSt = uneConnexion
							.prepareStatement("DELETE From pizza where codepizza=?");
					deletePizzaSt.setString(1, codePizza);
					deletePizzaSt.executeUpdate();
				}
			}

			// Etape 6 - Fermeture des ressources

			st.close();

			uneConnexion.close();

		} catch (SQLException e) {
			throw new DataAccessException("Problème accès en base", e);
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Problème no name", e);
		}

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
