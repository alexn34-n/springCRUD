package ru.alexn.springcrud.dao;

import org.springframework.stereotype.Component;
import ru.alexn.springcrud.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {

    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> index() {
        List<Product> products = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Product";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getInt("price"));


                products.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return products;
    }

    public Product show(int id) {

        return null;
    }

    public void save(Product product) {


        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Product VALUES(" + 1 + ",'" + product.getTitle() +
                    "'," + product.getPrice() +")";

            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void update(int id, Product updatedPerson) {

    }

    public void delete(int id) {

    }
}




















