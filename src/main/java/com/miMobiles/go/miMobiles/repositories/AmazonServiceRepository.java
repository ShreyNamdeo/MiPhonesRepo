package com.miMobiles.go.miMobiles.repositories;

import com.miMobiles.go.miMobiles.models.AmazonService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shrey on 3/27/2019.
 */
public interface AmazonServiceRepository  extends JpaRepository<AmazonService,Long> {
    AmazonService findByServiceName(String serviceName);
}
