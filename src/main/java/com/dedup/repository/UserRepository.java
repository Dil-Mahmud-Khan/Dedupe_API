package com.dedup.repository;

import com.dedup.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo,Integer> {
    boolean existsByFirstName(String firstName);
    boolean existsByNid(String nid);


}
