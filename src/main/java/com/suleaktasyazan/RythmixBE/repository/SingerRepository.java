package com.suleaktasyazan.RythmixBE.repository;

import com.suleaktasyazan.RythmixBE.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SingerRepository extends JpaRepository<Singer,String> {
    Optional<Singer> findByName(String name);
}
