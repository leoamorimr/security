package com.leoamorimr.security.service;

import java.util.List;

import com.leoamorimr.security.domain.Role;
import com.leoamorimr.security.domain.User;

public interface UserService {

  User saveUser(User user);

  Role saveRole(Role role);

  void addRoleToUser(String username, String roleName);

  User getUser(String username);

  List<User> getUsers();

}
