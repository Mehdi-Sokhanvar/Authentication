package ir.maktab.authenticationhibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder



@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    //todo study a bout
    @OneToOne
    private User user;

    @OneToMany(mappedBy = "role")
    private List<Permission> permissions = new ArrayList<>();


}
