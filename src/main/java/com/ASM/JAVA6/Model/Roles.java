package com.ASM.JAVA6.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "roles")
public class Roles implements Serializable{
    @Id
    @Column(name = "id")
    private String roleId;
    private String name;
    
    @JsonIgnore
    @OneToMany(mappedBy = "roleid")
    List<Authorities> authorities;
}
