package z_helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SampleDBHelper {

    public static void createTableUsersWithOneUser() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "rootpwd");
             Statement stmt = connection.createStatement()) {

            String sql = "CREATE TABLE USERS " +
                    "(id INTEGER not NULL, " +
                    " firstname VARCHAR(255), " +
                    " lastname VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);

            String sqlInsert = "INSERT INTO USERS " +
                    "VALUES (1, 'Dimitris', 'Kasiaras')";
            stmt.execute(sqlInsert);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void createJPATable () {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "rootpwd");
             Statement stmt = connection.createStatement()) {
            String sql = null;

            sql = "DROP TABLE GROUPS_USERS ";
            try {
                stmt.executeUpdate(sql);
            }catch (Exception e) {
                e.printStackTrace();
            }

            sql = "DROP TABLE GROUPS ";
            try {
                stmt.executeUpdate(sql);
            }catch (Exception e) {
                e.printStackTrace();
            }

            sql = "DROP TABLE COMMENTS ";
            try {
                stmt.executeUpdate(sql);
            }catch (Exception e) {
                e.printStackTrace();
            }

            sql = "DROP TABLE USERS; ";
            try {
                stmt.executeUpdate(sql);
            }catch (Exception e) {
                e.printStackTrace();
            }

            sql = "DROP TABLE ADDRESSES ";
            try {
            stmt.executeUpdate(sql);
            }catch (Exception e) {
                e.printStackTrace();
            }

            sql = "CREATE TABLE ADDRESSES (ID INTEGER NOT NULL AUTO_INCREMENT,  STREET VARCHAR (255), STREET_NUMBER INTEGER,  PRIMARY KEY ( ID ))";
            stmt.execute(sql);

            sql = "CREATE TABLE USERS " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " firstname VARCHAR(255), " +
                    " lastname VARCHAR(255), " +
                    " address_id INTEGER, " +
                    " PRIMARY KEY ( id )," +
                    " FOREIGN KEY (address_id) REFERENCES ADDRESSES(ID))";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE COMMENTS (ID INTEGER NOT NULL AUTO_INCREMENT,  COMMENT VARCHAR (255), USER_ID INTEGER,  " +
                    " PRIMARY KEY ( ID ), " +
                    " FOREIGN KEY ( USER_ID ) REFERENCES USERS( ID ))";
            stmt.execute(sql);

            sql = "CREATE TABLE GROUPS (ID INTEGER NOT NULL AUTO_INCREMENT,  GROUP_NAME VARCHAR (255), " +
                    " PRIMARY KEY ( ID ))";
            stmt.execute(sql);

            sql = "CREATE TABLE GROUPS_USERS (USER_ID INTEGER NOT NULL, GROUP_ID  INTEGER NOT NULL, PRIMARY KEY ( USER_ID, GROUP_ID ))";
            stmt.execute(sql);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
