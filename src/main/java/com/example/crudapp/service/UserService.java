package com.example.crudapp.service;

import com.example.crudapp.model.entity.UserEntity;
import com.example.crudapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.lang.ref.Reference;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository repo;


  public UserEntity delete(Integer id) {
    UserEntity entity = findById(id);
    repo.delete(entity);
    return entity;
  }

  public UserEntity save(UserEntity newUserEntity) {
    UserEntity userEntity = repo.save(newUserEntity);
    return userEntity;
  }

  public List<UserEntity> findAll() {
    return repo.findAll();
  }


  public UserEntity findById(Integer id) {

    UserEntity userEntity = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("TEST EXCPTION"));
    return userEntity;
  }


  public UserEntity update(Integer id, String newName) {
    UserEntity updatedUserEntity = findById(id);
    System.out.println(updatedUserEntity);
    updatedUserEntity.setName(newName);
    repo.save(updatedUserEntity);
    return updatedUserEntity;
  }

}
