package com.example.crudapp.repository;

import com.example.crudapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  @Query
          (value = "SELECT * FROM user WHERE name=?1", nativeQuery = true)
  UserEntity findByUserName(String name);

}
