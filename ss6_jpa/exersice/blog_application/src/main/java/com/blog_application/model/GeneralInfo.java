package com.blog_application.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Embeddable
public class GeneralInfo {
    private Date createAt;
    private Date updateAt;

    public GeneralInfo() {
    }

    public GeneralInfo(Date createAt, Date updateAt) {
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @PrePersist
    protected void onCreate() {
        updateAt = createAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = new Date();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
