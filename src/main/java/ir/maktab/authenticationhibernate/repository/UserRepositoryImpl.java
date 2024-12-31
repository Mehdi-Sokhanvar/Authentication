package ir.maktab.authenticationhibernate.repository;

import JPAHelper.repository.BaseRepositoryImpl;
import ir.maktab.authenticationhibernate.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {



    @Override
    protected Class<User> entityClass() {
        return User.class;
    }


    @Override
    public Optional<User> findByEmail(User user) throws NoResultException {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("email"), user.getEmail()));
        return Optional.ofNullable(entityManager.createQuery(criteriaQuery).getSingleResult());
    }

}
