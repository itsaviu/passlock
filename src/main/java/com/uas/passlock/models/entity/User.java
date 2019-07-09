package com.uas.passlock.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uas.passlock.models.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String emailId;

    private Boolean verified;

    private String mobileNumber;

    private Date createdAt;

    public User(String username, String password, String emailId, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.verified = false;
        this.createdAt = new Date();
    }
}
