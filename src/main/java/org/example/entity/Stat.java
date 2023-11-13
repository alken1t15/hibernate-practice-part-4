package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stat", schema = "todolist", catalog = "hibernate_study")
public class Stat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "completed_total", updatable = false )
    private Long completedTotal;
    @Basic
    @Column(name = "uncompleted_total", updatable = false)
    private Long uncompletedTotal;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


}
