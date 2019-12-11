package com.company.shop.form;

import java.util.Objects;

public class UserPropertyForm {
    private String name;
    private String login;
    private String password;
    private String confirmedPassword;
    private String email;

    public UserPropertyForm() {
    }

    public UserPropertyForm(String name, String login, String password, String checkablePassword, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.confirmedPassword = checkablePassword;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPropertyForm)) return false;
        UserPropertyForm that = (UserPropertyForm) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getConfirmedPassword(), that.getConfirmedPassword()) &&
                Objects.equals(getEmail(), that.getEmail());
    }
}
