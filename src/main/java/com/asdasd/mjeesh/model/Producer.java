package com.asdasd.mjeesh.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producer")
@Data
@NoArgsConstructor
public class Producer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_id")
    private List<Contact> contacts = new ArrayList<>();
}
