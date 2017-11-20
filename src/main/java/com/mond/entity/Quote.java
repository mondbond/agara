package com.mond.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by User on 19.11.2017.
 */

@Entity
@Table(name = "quote")
public class Quote implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author_id;

    @Column(name = "text")
    private String text;

    @Column(name = "info")
    private String info;

    public Quote() {}

    public Quote(String text, String info) {
        this.text = text;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Author author_id) {
        this.author_id = author_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
