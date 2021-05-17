package jpa_exercise;

import jpa_exercise.model.Address;
import jpa_exercise.model.Order;
import jpa_exercise.model.Product;
import jpa_exercise.utils.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    public static void main(String[] args) {
        //TODO create entityManagerFactory from the Exercise Persistence Unit
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProductOrdersDB");
        //TODO create entityManage
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Util.createTablesForExercise();

        Address address = new Address();
        address.setStreet("ethnikis antistasews");
        address.setNumber(22);

        //TODO Save the address
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        Product pen = new Product();
        pen.setName("pen");
        pen.setDescription("a beautiful pen");

        Product book = new Product();
        book.setName("book");
        book.setDescription("a beautiful book");

        //TODO save the book
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        //TODO create a new order with the address and the products
        Order order = new Order();
        order.setAddress(address);
        order.setProducts(List.of(pen, book));
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();

        //TODO print all the orders from the database
        entityManager.getTransaction().begin();
        List<Order> orders = entityManager.createQuery("SELECT * FROM ORDERS_EX").getResultList();
        for (Order o: orders
             ) {
            System.out.println(o.toString());
        }

        entityManager.close();
        entityManagerFactory.close();

        System.out.println("****** Done *******");
    }
}
