package com.pazyniuk.passive.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "genre")
    private int genre;

    @Column(name = "author")
    private int author;

    @Column(name = "name")
    private String name;

    @Column(name = "record_label")
    private int recordLabel;

    @Column(name = "price")
    private float price;

    @Column(name = "download_count")
    private int downloadCount;

    @Column(name = "album")
    private int album;

    public final int getGenre() {
        return genre;
    }

    public final void setGenre(int genre) {
        this.genre = genre;
    }

    public final int getAuthor() {
        return author;
    }

    public final void setAuthor(int author) {
        this.author = author;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final int getRecordLabel() {
        return recordLabel;
    }

    public final void setRecordLabel(int recordLabel) {
        this.recordLabel = recordLabel;
    }

    public final float getPrice() {
        return price;
    }

    public final void setPrice(float price) {
        this.price = price;
    }

    public final int getDownloadCount() {
        return downloadCount;
    }

    public final void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public final int getAlbum() {
        return album;
    }

    public final void setAlbum(int album) {
        this.album = album;
    }

    public final long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }
}
