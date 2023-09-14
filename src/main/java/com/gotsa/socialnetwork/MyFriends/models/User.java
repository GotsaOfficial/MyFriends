package com.gotsa.socialnetwork.MyFriends.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private String tel;
    private String address;
    private Role role;
    private Status status;
    private Boolean enabled;
    private Boolean verified;
    @CreationTimestamp
    private LocalDate create_date;
    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL
    )
    private Set<Post> posts = new HashSet<Post>();
    private LocalDate b_day;
    private String about;

    public User() {
    }

    public User(Long id, String username, String password, String email, String first_name, String last_name, String tel, String address, Role role, Status status, Boolean enabled, Boolean verified, LocalDate create_date, Set<Post> posts, LocalDate b_day, String about) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.tel = tel;
        this.address = address;
        this.role = role;
        this.status = status;
        this.enabled = enabled;
        this.verified = verified;
        this.create_date = create_date;
        this.posts = posts;
        this.b_day = b_day;
        this.about = about;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public LocalDate getB_day() {
        return b_day;
    }

    public void setB_day(LocalDate b_day) {
        this.b_day = b_day;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
