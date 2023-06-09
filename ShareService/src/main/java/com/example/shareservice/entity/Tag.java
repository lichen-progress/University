package com.example.shareservice.entity;

import org.springframework.stereotype.Service;

@Service
public class Tag {

    private int tid             ;   // int unsigned | NO   | PRI | NULL    |       |
    private String name          ;// varchar(255) | NO   | UNI | NULL    |       |
    private int number_reference;   // int unsigned | YES  |     | 0       |       |
    private int creater         ;   // int unsigned | YES  | MUL | NULL    |       |
    private int state           ;   // smallint     | NO   |     | 0       |       |

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_reference() {
        return number_reference;
    }

    public void setNumber_reference(int number_reference) {
        this.number_reference = number_reference;
    }

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
