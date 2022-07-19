package com.bloggingapplication.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="postId")
    private Integer postId;

    @Column(name = "postTitle",length=100,nullable = false)
    private String postTitle;

    private String comment;

    private String imageName;

    @Column(name="createdAt")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;


    public Post() {
    }

    public Post(Integer postId, String postTitle, String comment, String imageName, Date createdAt, User user, Category category) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.comment = comment;
        this.imageName = imageName;
        this.createdAt = createdAt;
        this.user = user;
        this.category = category;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", comment='" + comment + '\'' +
                ", imageName='" + imageName + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
