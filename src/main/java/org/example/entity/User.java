package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "hibernate_study")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String email;

    @Column(name = "userpassword")
    private String password;

    private String username;


    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}