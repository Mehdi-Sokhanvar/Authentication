package ir.maktab.authenticationhibernate.repository;

import ir.maktab.authenticationhibernate.model.User;
import ir.maktab.authenticationhibernate.model.dto.UserResponseDto;

import java.util.Optional;

public interface UserRepository {


    void save(User user);

    Optional<User> findByEmail(User user);

}
