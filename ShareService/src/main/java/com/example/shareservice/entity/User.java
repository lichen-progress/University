package com.example.shareservice.entity;

import org.springframework.context.annotation.Bean;


public class User {


     private int uid;              // uid      | int unsigned | NO   | PRI | NULL    | auto_increment |
     private String name;          // name     | varchar(255) | NO   |     | NULL    |                |
     private String avatar;        // avatar   | varchar(255) | YES  |     | NULL    |                |
     private String mail;          // mail     | varchar(255) | NO   | UNI | NULL    |                |
     private String password;      // password | varchar(255) | NO   |     | NULL    |                |
     private int type;          // type     | char(1)      | NO   |     | 0       |                |
     private int state;         // state    | char(255)    | NO   |     | 0       |                |

     public User(){}
     public User(int uid,String name,String avatar,String mail,String password){
          this.uid = uid;
          this.name = name;
          this.avatar = avatar;
          this.mail = mail;
          this.password = password;
     }




     /*
     * Getter and Setter
     *
     * */
     public int getUid() {
          return uid;
     }

     public void setUid(int uid) {
          this.uid = uid;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }
     public String getAvatar() {
          return avatar;
     }

     public void setAvatar(String avatar) {
          this.avatar = avatar;
     }

     public String getMail() {
          return mail;
     }

     public void setMail(String mail) {
          this.mail = mail;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public int getType() {
          return type;
     }

     public void setType(int type) {
          this.type = type;
     }

     public int getState() {
          return state;
     }

     public void setState(int state) {
          this.state = state;
     }

     /*
     * toString
     *
     * */

     @Override
     public String toString() {
          return "User{" +
                  "uid=" + uid +
                  ", name='" + name + '\'' +
                  ", avatar='" + avatar + '\'' +
                  ", mail='" + mail + '\'' +
                  ", password='" + password + '\'' +
                  ", type='" + type + '\'' +
                  ", state='" + state + '\'' +
                  '}';
     }
}
