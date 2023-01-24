package com.uammero.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.uammero.entity.RoleEntity;

@Repository
public interface RoleDao extends CrudRepository<RoleEntity,String> {

}
