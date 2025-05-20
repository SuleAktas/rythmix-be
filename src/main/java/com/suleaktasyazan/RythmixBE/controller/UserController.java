package com.suleaktasyazan.RythmixBE.controller;

import com.suleaktasyazan.RythmixBE.entity.Playlist;
import com.suleaktasyazan.RythmixBE.entity.Song;
import com.suleaktasyazan.RythmixBE.entity.User;
import com.suleaktasyazan.RythmixBE.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "api/user")

public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("likedSongs")
    public Set<Song> likedSongs(){
        return userService.getLikedSongs();
    }
    @GetMapping("/likedPlaylists")
    public Set<Playlist> likedPlaylists(){
        return userService.getLikedPlaylists();
    }

    @PostMapping()
    public User createUser(User user){
        return userService.createUser(user);
    }
    @PutMapping("/likeSong/{id}")
    public void likeSong(@PathVariable String id){
         userService.likeSong(id);
    }
    @PutMapping("/likePlaylist/{id}")
    public void likePlaylist(@PathVariable String id){
        userService.likePlaylist(id);
    }
    @PutMapping("/removeSong/{id}")
    public void removeSong(@PathVariable String id){
        userService.removeSong(id);
    }
    @PutMapping("/removePlaylist/{id}")
    public void removePlaylist(@PathVariable String id){
        userService.removePlaylist(id);
    }
    @GetMapping("/likedSong/{id}")
    public Boolean likedSong(@PathVariable String id){
        return userService.likedSong(id);
    }


}
