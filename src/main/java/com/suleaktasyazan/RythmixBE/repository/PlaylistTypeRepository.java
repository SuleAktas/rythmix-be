package com.suleaktasyazan.RythmixBE.repository;

import com.suleaktasyazan.RythmixBE.entity.PlaylistType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistTypeRepository  extends JpaRepository<PlaylistType,String> {
}
