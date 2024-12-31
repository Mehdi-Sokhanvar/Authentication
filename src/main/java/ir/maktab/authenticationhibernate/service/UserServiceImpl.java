package ir.maktab.authenticationhibernate.service;

import ir.maktab.authenticationhibernate.model.User;
import ir.maktab.authenticationhibernate.model.dto.UserRequestDTO;
import ir.maktab.authenticationhibernate.model.dto.UserResponseDTO;
import ir.maktab.authenticationhibernate.repository.UserRepository;

import javax.persistence.NoResultException;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserResponseDTO> signUp(UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .userName(userRequestDTO.getUsername())
                .password(userRequestDTO.getPassword())
                .email(userRequestDTO.getEmail())
                .phoneNumber(userRequestDTO.getPhoneNumber())
                .country(userRequestDTO.getCountry())
                .build();
        try {
            Optional<User> user1 = userRepository.findByEmail(user);
            return Optional.empty();
        } catch (NoResultException e) {
            userRepository.save(user);
            return Optional.of(UserResponseDTO.builder().username(userRequestDTO.getUsername()).build());
        }
        //todo when not found entity with this emiai occurs noresultException and them persisddata
    }

    @Override
    public Optional<UserResponseDTO> login(UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .userName(userRequestDTO.getUsername())
                .password(userRequestDTO.getPassword())
                .email(userRequestDTO.getEmail())
                .phoneNumber(userRequestDTO.getPhoneNumber())
                .country(userRequestDTO.getCountry())
                .build();
        try {
            Optional<User> user1 = userRepository.findByEmail(user);
            if (user1.get().getEmail().equals(userRequestDTO.getEmail()) &&
                    user1.get().getPassword().equals(userRequestDTO.getPassword())) {
                return Optional.of(
                        UserResponseDTO.builder().username(user.getUserName())
                                .role(String.valueOf(user.getRole())).build());
            }
            return Optional.empty();
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
