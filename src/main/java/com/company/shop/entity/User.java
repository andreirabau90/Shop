package com.company.shop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_name",nullable = false)
    private String name;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    UserProperty userProperty;
    @JsonManagedReference
    @OneToOne(mappedBy = "user",  fetch = FetchType.LAZY)
    private Basket basket;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Basket getBasket() {
        return basket;
    }


}
