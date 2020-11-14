package com.pazyniuk.passive.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_song")
public class UserSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "id_user")
    private long idUser;

    @Column(name = "id_song")
    private long idSong;

    public final long getIdUser() {
        return idUser;
    }

    public final void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public final long getIdSong() {
        return idSong;
    }

    public final void setIdSong(long idSong) {
        this.idSong = idSong;
    }

    public final long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }
}
