package com.uas.passlock.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uas.passlock.converters.PassConverter;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PassVault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String name;

    private String identity;

    @Convert(converter = PassConverter.class)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdAt;


    public PassVault(String url, String name, String identity, String password, User user) {
        this.url = url;
        this.name = name;
        this.identity = identity;
        this.password = password;
        this.user = user;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
