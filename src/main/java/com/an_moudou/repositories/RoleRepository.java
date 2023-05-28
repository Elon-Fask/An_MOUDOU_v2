package com.an_moudou.repositories;

import com.an_moudou.entities.Role;
import com.an_moudou.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
