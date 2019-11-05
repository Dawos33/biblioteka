package com.biblioteka.biblioteka.entities;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
public class Admin {
    @GeneratedValue
    @Id
    @Column(name = "id_administrator")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "haslo")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
