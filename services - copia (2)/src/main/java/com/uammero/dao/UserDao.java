package com.uammero.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.uammero.entity.UserEntity;

@Repository
public interface UserDao extends CrudRepository<UserEntity,String>{

}
