package com.suleaktasyazan.RythmixBE.controller;

import com.suleaktasyazan.RythmixBE.dto.DTOPlaylistType;
import com.suleaktasyazan.RythmixBE.entity.PlaylistType;
import com.suleaktasyazan.RythmixBE.service.IPlaylistTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/playlist-type")

public class PlaylistTypeController {

    @Autowired
    private IPlaylistTypeService playlistTypeService;


    @GetMapping(path = "/{id}")
    public PlaylistType getPlaylistType(@PathVariable(name = "id")String id){
        return  playlistTypeService.getPlaylistType(id);
    }

    @PostMapping
    public PlaylistType createPlaylistType(@RequestBody DTOPlaylistType dtoPlaylistType){
        return playlistTypeService.createPlaylistType(dtoPlaylistType);
    }

}
