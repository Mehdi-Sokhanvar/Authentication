package ir.maktab.authenticationhibernate.repository;

import JPAHelper.repository.BaseRepository;
import ir.maktab.authenticationhibernate.model.User;

import javax.persistence.NoResultException;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {


    Optional<User> findByEmail(User user) throws NoResultException;

}
