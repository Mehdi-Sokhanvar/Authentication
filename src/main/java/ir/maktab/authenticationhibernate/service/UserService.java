package ir.maktab.authenticationhibernate.service;

import ir.maktab.authenticationhibernate.model.dto.UserRequestDTO;
import ir.maktab.authenticationhibernate.model.dto.UserResponseDTO;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {

    Optional<UserResponseDTO> signUp(UserRequestDTO user);

    Optional<UserResponseDTO> login(UserRequestDTO build);
}
