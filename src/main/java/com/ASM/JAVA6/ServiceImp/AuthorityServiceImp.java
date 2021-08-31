package com.ASM.JAVA6.ServiceImp;

import java.util.List;

import com.ASM.JAVA6.DAO.AccountDAO;
import com.ASM.JAVA6.DAO.AuthoritiesDAO;
import com.ASM.JAVA6.Model.Accounts;
import com.ASM.JAVA6.Model.Authorities;
import com.ASM.JAVA6.Service.AuthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImp implements AuthorityService {

  @Autowired
  AuthoritiesDAO authorityDAO;

  @Autowired
  AccountDAO accountDAO;

  @Override
  public List<Authorities> findAuthoritiesOfAdministrators() {
    List<Accounts> accounts = accountDAO.getAdministrator();
    return authorityDAO.authoritiesOf(accounts);
  }

  @Override
  public List<Authorities> findAll() {
    return authorityDAO.findAll();
  }

  @Override
  public Authorities create(Authorities auth) {
    return authorityDAO.save(auth);
  }

  @Override
  public void delete(Integer id) {
    authorityDAO.deleteById(id);
  }

}
