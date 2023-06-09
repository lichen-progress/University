package com.example.shareservice.entity;

import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class Comment {

    private int  cid     ;// int unsigned | NO   | PRI | NULL    |       |
    private String  contain ;// text         | NO   |     | NULL    |       |
    private Date date    ;// datetime     | NO   |     | NULL    |       |
    private int  state   ;// smallint     | NO   |     | 0       |       |

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
