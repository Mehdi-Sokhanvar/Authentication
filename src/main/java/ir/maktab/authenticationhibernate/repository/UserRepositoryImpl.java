package ir.maktab.authenticationhibernate.repository;

import ir.maktab.authenticationhibernate.model.User;
import ir.maktab.authenticationhibernate.model.dto.UserResponseDto;
import ir.maktab.authenticationhibernate.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private EntityManager entityManager;


    public UserRepositoryImpl() {
        this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }



    @Override
    public Optional<User> findByEmail(User user) throws NoResultException {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("userName"), user.getEmail()));
        return Optional.ofNullable(entityManager.createQuery(criteriaQuery).getSingleResult());
    }


}
