package com.suleaktasyazan.RythmixBE.service.impl;

import com.suleaktasyazan.RythmixBE.entity.Song;
import com.suleaktasyazan.RythmixBE.repository.SingerRepository;
import com.suleaktasyazan.RythmixBE.repository.SongRepository;
import com.suleaktasyazan.RythmixBE.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private SongRepository songRepository;


    @Override
    public List<Song> getAllSongs() {
        return songRepository.findRandom10Songs();
    }

    @Override
    public Song getSong(String id) {
        Optional<Song> optional = songRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Song createSong(Song song) {
        songRepository.save(song);
        return song;
    }


}
