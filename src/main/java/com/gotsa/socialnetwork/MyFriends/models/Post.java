package com.gotsa.socialnetwork.MyFriends.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String title;
    private String mini_text;
    private String text;
    private Integer likes;
    private Integer views;
    @ManyToOne
    private User owner;
    @CreationTimestamp
    private LocalDate create_date;
    @UpdateTimestamp
    private LocalDate update_date;

    public Post() {
    }

    public Post(Long id, String title, String mini_text, String text, Integer likes, Integer views, User owner, LocalDate create_date, LocalDate update_date) {
        this.id = id;
        this.title = title;
        this.mini_text = mini_text;
        this.text = text;
        this.likes = likes;
        this.views = views;
        this.owner = owner;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMini_text() {
        return mini_text;
    }

    public void setMini_text(String mini_text) {
        this.mini_text = mini_text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public LocalDate getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDate update_date) {
        this.update_date = update_date;
    }
}
