package com.example.crudapp.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class UserEntity {


  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String surname;

  public UserEntity(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

}
