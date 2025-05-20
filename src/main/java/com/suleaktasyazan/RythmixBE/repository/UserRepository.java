package com.suleaktasyazan.RythmixBE.repository;

import com.suleaktasyazan.RythmixBE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByOrderByIdAsc();
}
