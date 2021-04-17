package f_jpa_example.relationships;

import f_jpa_example.model.*;
import z_helper.SampleDBHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        SampleDBHelper.createJPATable();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UsersDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        /** One to One */
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet("ethnikis antistasews");
        addressEntity.setNumber(22);

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Giwrgos");
        userEntity.setLastName("Papadopoulos");
        userEntity.setAddressEntity(addressEntity);

        entityManager.getTransaction().begin();
        entityManager.persist(userEntity);
        entityManager.getTransaction().commit();



        /** One to Many - Many to One */
        Comment comment1 = new Comment();
        comment1.setComment("comment1");
        comment1.setUserEntity(userEntity);

        Comment comment2 = new Comment();
        comment2.setComment("comment2");
        comment2.setUserEntity(userEntity);

        entityManager.getTransaction().begin();
        entityManager.persist(comment1);
        entityManager.persist(comment2);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        UserEntity fetchedUser = entityManager.find(UserEntity.class, 1);
        System.out.println(fetchedUser);
        entityManager.close();


        /** Many to Many example*/
        entityManager = entityManagerFactory.createEntityManager();
        UserEntity userEntity1 = entityManager.find(UserEntity.class, 1);
        Group group1 = new Group();
        group1.setGroupName("group 1");
        group1.addUser(userEntity1);
        entityManager.getTransaction().begin();
        entityManager.persist(group1);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        Group fetchedGroup = entityManager.find(Group.class, 1);
        System.out.println(fetchedGroup);
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        fetchedUser = entityManager.find(UserEntity.class, 1);
        System.out.println(fetchedUser);
        entityManager.close();

    }
}
