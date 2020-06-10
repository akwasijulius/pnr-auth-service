package com.jogsoft.apps.pnr.authservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "User")
public class User {
    //private int id;
    @Id
    @Column(name = "USERNAME")
    private String userName;
    private String password;
    private String role;
    private boolean enabled;
}
