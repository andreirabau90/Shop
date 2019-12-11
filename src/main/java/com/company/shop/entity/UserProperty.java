package com.company.shop.entity;

import javax.persistence.*;


@Entity
@Table(name = "user_property")
public class UserProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private long propId;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(unique = true, name = "user_id")
    User user;

    public UserProperty() {
    }

    public UserProperty(String login, String password, String email, User user) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
