package com.biblioteka.entities;

import javax.persistence.*;

@Entity
@Table(name = "bibliotekarz")
public class Liberian {
    @GeneratedValue
    @Id
    @Column(name = "id_bibliotekarz")
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
        return "Liberian{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
