package com.leoamorimr.security.service;

import java.util.List;

import com.leoamorimr.security.domain.Role;
import com.leoamorimr.security.domain.User;
import com.leoamorimr.security.repo.RoleRepo;
import com.leoamorimr.security.repo.UserRepo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;
  private final RoleRepo roleRepo;

  @Override
  public User saveUser(User user) {
    log.info("Saving new user {} to database", user.getName());
    return userRepo.save(user);
  }

  @Override
  public Role saveRole(Role role) {
    log.info("Saving new role {} to database", role.getName());
    return roleRepo.save(role);
  }

  @Override
  public void addRoleToUser(String userName, String roleName) {
    log.info("Adding role {} to user {}", roleName, userName);

    User user = userRepo.findByUsername(userName);
    Role role = roleRepo.findByName(roleName);
    user.getRoles().add(role);
  }

  @Override
  public User getUser(String userName) {
    log.info("Fetching user {}", userName);
    return userRepo.findByUsername(userName);
  }

  @Override
  public List<User> getUsers() {
    log.info("Fetching all users");
    return userRepo.findAll();
  }

}
