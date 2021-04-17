package f_jpa_example;

import f_jpa_example.model.User;
import z_helper.SampleDBHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        SampleDBHelper.createJPATable();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsersDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        User user = new User();
        user.setFirstName("kostas");
        user.setLastName("pavlidis");

        entityManager.persist(user);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
