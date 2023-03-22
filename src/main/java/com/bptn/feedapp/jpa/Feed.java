package com.bptn.feedapp.jpa;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="\"Feed\"")
public class Feed implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="\"feedId\"")
    private Integer feedId;

    private String picture;

    private String content;

    @Column(name="\"createdOn\"")
    private Timestamp createdOn;

    @ManyToOne
    @JoinColumn(name="\"userId\"")
    private User user;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy="feed", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<FeedMetaData> feedMetaData;

    public Feed() {
    }

    public Integer getFeedId() {
        return feedId;
    }

    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<FeedMetaData> getFeedMetaData() {
        return feedMetaData;
    }

    public void setFeedMetaData(List<FeedMetaData> feedMetaData) {
        this.feedMetaData = feedMetaData;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "feedId=" + feedId +
                ", picture='" + picture + '\'' +
                ", content='" + content + '\'' +
                ", createdOn=" + createdOn +
                ", user=" + user +
                ", feedMetaData=" + feedMetaData +
                '}';
    }


}
