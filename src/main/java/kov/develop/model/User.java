package kov.develop.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "userslist")
@Data
@NoArgsConstructor
@EqualsAndHashCode( exclude = "id")
public class User implements Serializable{

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @Column(name = "firstName")
    @NotBlank
    @Size(max = 15)
    private String firstName;

    @Column(name = "lastName")
    @NotBlank
    @Size(max = 30)
    private String lastName;

    @Column(name = "birthday")
    @NotNull
    private LocalDate birthday;

    @Column(name = "login")
    @Size(min = 4, max=10)
    @NotBlank
    private String login;

    @Column(name = "password")
    @Size(min=4, max = 10)
    @NotBlank
    private String password;

    @Column(name = "info")
    @Size(max = 200)
    private String info;

    @Column(name = "adress")
    @NotBlank
    @Size(max = 30)
    private String adress;
}

