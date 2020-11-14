package com.pazyniuk.passive.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itunes_user")
public class ItunesUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "joined_date")
    private String joinedDate;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    private int gender;

    @Column(name = "credit_card")
    private int creditCard;

    public final long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public final String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }

    public final String getJoinedDate() {
        return joinedDate;
    }

    public final void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getSurname() {
        return surname;
    }

    public final void setSurname(String surname) {
        this.surname = surname;
    }

    public final int getGender() {
        return gender;
    }

    public final void setGender(int gender) {
        this.gender = gender;
    }

    public final int getCreditCard() {
        return creditCard;
    }

    public final void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }
}
