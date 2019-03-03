package com.miMobiles.go.miMobiles.repositories;

import com.miMobiles.go.miMobiles.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shrey on 2/18/2019.
 */
public interface RoleRepository extends JpaRepository<Role,String> {
    Role getRoleById(String id);
}
