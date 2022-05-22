package com.feue.ml.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Feue
 * @create 2022-05-20 20:15
 */
@Entity
@Table(name = "course_star")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseStar extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long courseId;
}
