package cn.imust.blog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {
    @Id @GeneratedValue
    private Integer id;
    private String content;
    private Date date;
    private Integer flag;
    private BlogUser quser;
    private BlogUser auser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public BlogUser getQuser() {
        return quser;
    }

    public void setQuser(BlogUser quser) {
        this.quser = quser;
    }

    public BlogUser getAuser() {
        return auser;
    }

    public void setAuser(BlogUser auser) {
        this.auser = auser;
    }
}
