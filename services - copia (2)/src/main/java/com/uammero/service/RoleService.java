package com.uammero.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uammero.dao.RoleDao;
import com.uammero.entity.RoleEntity;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public RoleEntity createNewRole(RoleEntity role) {
        return roleDao.save(role);
    }
}
