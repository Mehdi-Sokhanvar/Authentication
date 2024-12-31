package ir.maktab.authenticationhibernate.model.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class UserRequestDTO {

//    @NotBlank
    private String username;

    @Length(min = 8)
    private String password;

    @Pattern(regexp = "0\\d{10}", message = "Phone number must start with 0 and be followed by 10 digits.")
    private String phoneNumber;

    @Email(message = "Please inter correct email")
    private String email;
//dashboardr
    private String country;


    public static Set<ConstraintViolation<UserRequestDTO>> cheakValidationUserRequest(UserRequestDTO userResponseDTO) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(userResponseDTO);
    }

}
