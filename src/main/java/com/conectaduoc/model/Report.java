package com.conectaduoc.model;

import java.sql.Date;

import io.micrometer.common.lang.NonNull;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Report {
    
    @Id
    private Long idReport;

    @Nullable
    private Long idPost;

    @Nullable
    private Long idComment;

    @Nullable
    private Long idUser;

    @NonNull
    private String reason;

    @NonNull
    private Integer status;

    @NonNull
    private Date date;

    public Long getIdReport() {
        return idReport;
    }
    
    public void setIdReport(Long idReport) {
        this.idReport = idReport;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
