package com.pazyniuk.passive.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private int country;

    @Column(name = "gender")
    private int gender;

    public final long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final int getCountry() {
        return country;
    }

    public final void setCountry(int country) {
        this.country = country;
    }

    public final int getGender() {
        return gender;
    }

    public final void setGender(int gender) {
        this.gender = gender;
    }
}
