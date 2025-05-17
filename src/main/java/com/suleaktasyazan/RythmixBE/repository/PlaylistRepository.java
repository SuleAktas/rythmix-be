package com.suleaktasyazan.RythmixBE.repository;

import com.suleaktasyazan.RythmixBE.entity.Playlist;
import com.suleaktasyazan.RythmixBE.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository  extends JpaRepository<Playlist,String> {
    @Query(value = "SELECT * FROM rythmix.playlist ORDER BY RANDOM() LIMIT 10", nativeQuery = true)
    List<Playlist> findRandom10Playlists();

    @Query("SELECT p.songs FROM Playlist p WHERE p.id = :playlistId")
    List<Song> findByPlaylistId(@Param("playlistId") String playlistId);

}
