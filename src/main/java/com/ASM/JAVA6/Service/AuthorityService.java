package com.ASM.JAVA6.Service;

import java.util.List;

import com.ASM.JAVA6.Model.Authorities;

public interface AuthorityService {

    List<Authorities> findAuthoritiesOfAdministrators();

    List<Authorities> findAll();

    Authorities create(Authorities auth);

    void delete(Integer id);
    
}
