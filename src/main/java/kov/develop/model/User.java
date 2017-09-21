package kov.develop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "userslist")
@Data
@NoArgsConstructor
@EqualsAndHashCode( exclude = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "firstName")
    @NotBlank
    private String firstName;

    @Column(name = "lastName")
    @NotBlank
    private String lastName;

    @Column(name = "birthday")
    @NotNull
    private LocalDate birthday;

    @Column(name = "login")
    @Size(min = 5, max=10)
    @NotBlank
    private String login;

    @Column(name = "password")
    @Size(min=5, max = 10)
    @NotBlank
    private String password;

    @Column(name = "info")
    private String info;

    @Column(name = "adress")
    @NotBlank
    private String adress;

}

