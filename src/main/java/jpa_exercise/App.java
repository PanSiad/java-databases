package jpa_exercise;

import jpa_exercise.model.Address;
import jpa_exercise.model.Product;

public class App {

    public static void main(String[] args) {
        Util.createTablesForExercise();

        Address address = new Address();
        address.setStreet("ethnikis antistasews");
        address.setNumber(22);

        //TODO Save the address

        Product pen = new Product();
        pen.setName("pen");
        pen.setDescription("a beautiful pen");

        Product book = new Product();
        book.setName("book");
        book.setDescription("a beautiful book");
        //TODO save the book


        //TODO create a new order with the address and the products

        //TODO print all the orders from the database


        System.out.println("****** Done *******");
    }
}
