package h_inheritance;

import h_inheritance.joinedtable.Fish;
import h_inheritance.joinedtable.Pet;
import h_inheritance.mappedsuperclass.MyEmployee;
import h_inheritance.singleTable.Book;
import h_inheritance.singleTable.Pen;
import h_inheritance.tableperclass.Motor;
import h_inheritance.tableperclass.Motorcycle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Inheritance");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        MyEmployee employee = new MyEmployee();
        employee.setCompany("Agile Actors");
        employee.setPersonId(1L);
        employee.setName("George");

        entityManager.persist(employee);
        entityManager.getTransaction().commit();



        /** single table */
        entityManager.getTransaction().begin();

        Book book = new Book();
        book.setAuthor("Joan Rowling");
        book.setName("Harry Potter");
        book.setProductId(1L);

        entityManager.persist(book);


        Pen pen = new Pen();
        pen.setName("magic pen");
        pen.setProductId(2L);
        pen.setColor("blue");

        entityManager.persist(pen);

        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();

        /** joined table **/
        Fish fish = new Fish();
        fish.setAnimalId(1L);
        fish.setName("swordfish");
        fish.setColor("blue");

        entityManager.persist(fish);

        Pet pet = new Pet();
        pet.setLegs(4);
        pet.setName("dog");
        pet.setAnimalId(2L);

        entityManager.persist(pet);

        entityManager.getTransaction().commit();



        /** table per class */
        entityManager.getTransaction().begin();

        Motor motor = new Motor();
        motor.setFuel("gasoline");
        motor.setVehicleId(1L);
        motor.setManufacturer("Ferrari");

        entityManager.persist(motor);

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setNumOfTires(3);
        motorcycle.setVehicleId(2L);
        motorcycle.setManufacturer("Honda");

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
