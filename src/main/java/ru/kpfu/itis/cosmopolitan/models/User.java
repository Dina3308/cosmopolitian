package ru.kpfu.itis.cosmopolitan.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String name;

    private String email;

    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public enum Role {
        USER, ADMIN
    }

    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }

    @OneToOne(mappedBy = "user")
    private Basket basket;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
