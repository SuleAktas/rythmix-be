package com.suleaktasyazan.RythmixBE.repository;

import com.suleaktasyazan.RythmixBE.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository  extends JpaRepository<Song,String> {
    Optional<Song> findByName(String name);

    @Query(value = "SELECT * FROM rythmix.song ORDER BY RANDOM() LIMIT 10", nativeQuery = true)
    List<Song> findRandom10Songs();


}
