package com.company.shop.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name",nullable = false)
    private String name;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "description",nullable = false)
    private String description;
    @ManyToOne()
    @JsonManagedReference
    @JoinColumn(name = "product_group", nullable = false)
    private ProductGroups group;
    @JsonBackReference
    @ManyToMany(mappedBy = "basketProducts" , cascade = CascadeType.PERSIST)
    private List<Basket> baskets = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ProductGroups getGroup() {
        return group;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                Double.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getGroup().getId(), product.getGroup().getId());
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        result = 37 * result + name.hashCode();
        result = 37 * result + description.hashCode();
        result =  37 * result + (int) group.getId();
        return result;
    }

    @Override
    public String
    toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
