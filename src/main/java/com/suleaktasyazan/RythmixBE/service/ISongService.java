package com.suleaktasyazan.RythmixBE.service;

import com.suleaktasyazan.RythmixBE.entity.Song;

import java.util.List;

public interface ISongService {

    public List<Song> getAllSongs();

    public Song getSong(String id);

    public Song createSong(Song song);


}
