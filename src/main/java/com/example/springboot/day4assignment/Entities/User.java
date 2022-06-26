package com.example.springboot.day4assignment.Entities;

import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Table(name = "users")
public class User extends Base{
    @Id
    private long id;
    private String name;
    private String surname;
    private String cardNo;
    private String username;
    private String password;
    private String email;

    public User(){
        super();
    }
    public User(long id, String name, String username, String cardNo, String surname, String password, String email, LocalDateTime createdAt, String createBy){
        super(createdAt, createBy);
        this.id = id;
        this.name = name;
        this.cardNo = cardNo;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }
}
