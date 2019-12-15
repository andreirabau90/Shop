package com.company.shop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "user_name", nullable = false)
    private String name;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private
    UserProperty userProperty;
    @JsonManagedReference
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
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

    public UserProperty getUserProperty() {
        return userProperty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserProperty(UserProperty userProperty) {
        this.userProperty = userProperty;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.basket = new Basket();
    }
}
