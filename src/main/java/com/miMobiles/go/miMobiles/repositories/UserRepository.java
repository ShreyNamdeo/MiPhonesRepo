package com.miMobiles.go.miMobiles.repositories;

import com.miMobiles.go.miMobiles.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shrey on 2/18/2019.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> getById(Long id);
}
