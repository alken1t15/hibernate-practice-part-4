package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "hibernate_study")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String email;

    @Column(name = "userpassword")
    private String password;

    private String username;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Category> categories;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Priority> priorities;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Activity activity;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Stat stat;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", schema = "todolist", catalog = "hibernate_study",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}