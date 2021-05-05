package f_jpa_example.critetia;

import f_jpa_example.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaExample {

    private final EntityManager entityManager;

    public CriteriaExample(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> findByCriteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("firstName"), "%papa%"));

        TypedQuery<User> q = entityManager.createQuery(criteriaQuery);
        List<User> fetchedUsers = q.getResultList();
        return fetchedUsers;
    }
}
