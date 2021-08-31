package com.ASM.JAVA6.Model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Accounts implements Serializable{

    @Id
    private String username;
    private String email;
    private String fullname;
    private String password;
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Orders> orders;
    
    @JsonIgnore
    @OneToMany(mappedBy = "username", fetch = FetchType.EAGER)
    List<Authorities> authorities;
}

