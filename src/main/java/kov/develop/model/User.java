package kov.develop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "userslist")
@Data
//@NoArgsConstructor
@EqualsAndHashCode( exclude = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect
public class User implements Serializable{

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
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

    public User() {
    }
}

