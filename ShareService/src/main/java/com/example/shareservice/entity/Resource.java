package com.example.shareservice.entity;

import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class Resource {
    private int rid          ;// int unsigned     | NO   | PRI | NULL    | auto_increment |
    private String date         ;// datetime         | NO   |     | NULL    |                |
    private int holder       ;// int unsigned     | YES  | MUL | NULL    |                |
    private String title       ;// varchar(255)     | NO   | MUL | NULL    |                |
    private String html;// varchar(255)     | YES  |     | NULL    |                |
    private String resource     ;// varchar(255)     | NO   |     | NULL    |                |
    private int visits       ;// int unsigned     | YES  |     | 0       |                |
    private int collect      ;// int unsigned     | YES  |     | 0       |                |
    private int comment      ;// int unsigned     | YES  |     | 0       |                |
    private int state        ;// tinyint unsigned | NO   |     | 0       |




    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHolder() {
        return holder;
    }

    public void setHolder(int holder) {
        this.holder = holder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        System.out.println("onset"+html);
        this.html = html;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "rid=" + rid +
                ", date=" + date +
                ", holder=" + holder +
                ", title='" + title + '\'' +
                ", html_location='" + html + '\'' +
                ", resource='" + resource + '\'' +
                ", visits=" + visits +
                ", collect=" + collect +
                ", comment=" + comment +
                ", state=" + state +
                '}';
    }
}
