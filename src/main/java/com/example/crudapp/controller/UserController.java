package com.example.crudapp.controller;

import com.example.crudapp.model.entity.UserEntity;
import com.example.crudapp.repository.UserRepository;
import com.example.crudapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

  private UserService service;

  @GetMapping("/all")
  public List<UserEntity> getAllUsers() {
    return service.findAll();
  }

  @GetMapping("/user-by-id/{id}")
  public UserEntity getUserById(@PathVariable Integer id) {
    return service.findById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/create")
  public UserEntity createUser(@RequestParam String name,
                               @RequestParam String surname) {
    UserEntity userEntity = new UserEntity(name, surname);
    return service.save(userEntity);
  }

  @PutMapping("/update/")
  public UserEntity updateUserEntityById(@RequestParam Integer id,
                                         @RequestParam String newName) {
    System.out.println("User updated");
    return service.update(id, newName);
  }
  @DeleteMapping("/delete/{id}")
  public UserEntity deleteUserById(@PathVariable Integer id) {
    System.out.println("User Deleted");
    return service.delete(id);
  }
}
