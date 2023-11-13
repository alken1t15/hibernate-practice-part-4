package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "priority", schema = "todolist", catalog = "hibernate_study")
@Getter
@Setter
@NoArgsConstructor
public class Priority {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;


    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


}