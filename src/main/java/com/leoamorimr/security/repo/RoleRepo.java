package com.leoamorimr.security.repo;

import com.leoamorimr.security.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

  Role findByName(String name);
  
}
