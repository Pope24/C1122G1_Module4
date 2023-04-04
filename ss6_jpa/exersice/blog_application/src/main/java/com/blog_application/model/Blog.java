package com.blog_application.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String image;
    @Embedded
    private GeneralInfo generalInfo;
    @ManyToOne
    private TypeBlog typeBlog;

    public Blog() {
        generalInfo = new GeneralInfo();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TypeBlog getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(TypeBlog typeBlog) {
        this.typeBlog = typeBlog;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }
}
