package com.feue.ml.entity;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author Feue
 * @create 2022-04-24 19:13
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chapter")
@Where(clause = "delete_time is null")
public class Chapter extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer order;
    private String name;
    private String about;
    private Long courseId;
    private Date startTime;
    private Date endTime;
}
