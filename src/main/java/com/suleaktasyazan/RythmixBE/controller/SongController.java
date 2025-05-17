package com.suleaktasyazan.RythmixBE.controller;

import com.suleaktasyazan.RythmixBE.entity.Song;
import com.suleaktasyazan.RythmixBE.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }
    @GetMapping(path = "/{id}")
    public Song getSong(@PathVariable(name = "id")String id){
        return songService.getSong(id);
    }
    @PostMapping
    public Song createSong(@RequestBody Song song){
        return songService.createSong(song);
    }

}
