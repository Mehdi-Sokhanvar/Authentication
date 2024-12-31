package ir.maktab.authenticationhibernate.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
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

    @OneToMany(mappedBy = "role")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @Builder.Default
    private List<Permission> permissions = Collections.singletonList(
            Permission.builder().name("READ_PRIVILEGES")
                    .build());


}
