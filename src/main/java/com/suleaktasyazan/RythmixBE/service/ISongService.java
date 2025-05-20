package com.suleaktasyazan.RythmixBE.service;

import com.suleaktasyazan.RythmixBE.dto.DTOSong;
import com.suleaktasyazan.RythmixBE.entity.Song;

import java.util.List;

public interface ISongService {

    public List<Song> getAllSongs();

    public Song getSong(String id);

    public Song createSong(Song song);

    public Song likeSong(String id);

    public List<DTOSong> getFilteredSongs(String query);

}
