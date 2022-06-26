package com.example.springboot.day4assignment.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends Base {
    @Id
    private long id;
    private String name;
    private String surname;
    private String cardNo;
    private String username;
    private String password;
    private String email;

}
