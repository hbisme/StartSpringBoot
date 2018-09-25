package com.hb.start_boot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class JpaUser implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name = "user_name")
    private String Username;

    @Column(name = "password")
    private String password;


}