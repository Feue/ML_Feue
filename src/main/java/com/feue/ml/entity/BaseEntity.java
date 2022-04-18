package com.feue.ml.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author Feue
 * @create 2022-04-17 13:54
 */
@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity {
    @Column(insertable = false, updatable = false)
    private Date createTime;
    @Column(insertable = false, updatable = false)
    private Date updateTime;
    private Date deleteTime;
}
