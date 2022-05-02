package com.asdasd.mjeesh.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
@Data
@NoArgsConstructor
public class Contact extends BaseEntity {

    @Column(name = "number")
    private Long number;

}
