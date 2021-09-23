package com.example.api.model;

import lombok.*;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tag;

    private boolean isChecked;

    private Date date;

    private int countViews;

    public Post(String title, String description, User user, Category category, List<Tag> tag, boolean isChecked, Date date, int countViews) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.category = category;
        this.tag = tag;
        this.isChecked = isChecked;
        this.date = date;
        this.countViews = countViews;
    }
}