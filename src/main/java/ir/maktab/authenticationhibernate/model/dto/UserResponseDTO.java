package ir.maktab.authenticationhibernate.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {

    private String username;
    private String password;
    private String role;
    private String country;
    private String phoneNumber;

}
