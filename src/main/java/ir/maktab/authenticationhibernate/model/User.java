package ir.maktab.authenticationhibernate.model;


import JPAHelper.model.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder


@Entity
@Table(name = "users")
public class User extends BaseModel<Long> {

    private String userName;

    private String password;

    private String email;

    private String country;

    private String phoneNumber;

    @OneToOne
    @Builder.Default
    @Cascade(value = org.hibernate.annotations.CascadeType.PERSIST)
    private Role role= Role.builder().name("USER").build();


}
