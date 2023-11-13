package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "category", schema = "todolist", catalog = "hibernate_study")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    @Basic
    @Column(name = "completed_count", updatable = false)
    private Long completedCount;
    @Basic
    @Column(name = "uncompleted_count", updatable = false)
    private Long uncompletedCount;

  @ManyToOne
          @JoinColumn(name = "user_id",referencedColumnName = "id")
   private User user;
}