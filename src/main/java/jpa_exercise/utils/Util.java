package jpa_exercise.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Util {

    public static void createTablesForExercise() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "rootpwd");
             Statement stmt = connection.createStatement()) {

            String sql = "DROP TABLE ADDRESSES_EX ";
            try {
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }

            sql = "DROP TABLE PRODUCTS_EX ";
            try {
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }

            sql = "DROP TABLE ORDERS_EX ";
            try {
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }


            sql = "DROP TABLE PRODUCTS_EX ";
            try {
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }

            sql = "CREATE TABLE ADDRESSES_EX " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " street VARCHAR(255), " +
                    " street_number INTEGER , " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE ORDERS_EX " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " order_date date, " +
                    " price  double , " +
                    " address_id  INTEGER , " +
                    " PRIMARY KEY ( id )," +
                    " FOREIGN KEY (address_id) REFERENCES ADDRESSES(ID))";

            stmt.executeUpdate(sql);


            sql = "CREATE TABLE PRODUCTS_EX " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " description  VARCHAR(255) , " +
                    " order_id  INTEGER , " +
                    " PRIMARY KEY ( id )," +
                    " FOREIGN KEY (order_id) REFERENCES ORDERS_EX(ID))";

            stmt.executeUpdate(sql);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
