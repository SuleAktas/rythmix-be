package com.suleaktasyazan.RythmixBE.controller;


import com.suleaktasyazan.RythmixBE.dto.DTOPlaylist;
import com.suleaktasyazan.RythmixBE.dto.DTOSong;
import com.suleaktasyazan.RythmixBE.entity.Playlist;
import com.suleaktasyazan.RythmixBE.service.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/playlist")

public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;


    @GetMapping
    public List<DTOPlaylist> getAllPlaylists(){
        return playlistService.getAllPlaylists();
    }

    @GetMapping(path = "/{id}")
    public Playlist getPlaylist(@PathVariable(name = "id") String id){
        return playlistService.getPlaylist(id);
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist){
        return playlistService.createPlaylist(playlist);
    }


    @GetMapping("/{id}/songs")
    public List<DTOSong> getSongsByPlaylistId(@PathVariable String id){
        return playlistService.getSongsByPlaylistId(id);
    }



}
