package com.suleaktasyazan.RythmixBE.service;

import com.suleaktasyazan.RythmixBE.entity.Playlist;
import com.suleaktasyazan.RythmixBE.entity.Song;
import com.suleaktasyazan.RythmixBE.entity.User;

import java.util.Set;

public interface IUserService {

    public User createUser(User user);

    public void likeSong(String id);

    public void likePlaylist(String id);

    public void removeSong(String id);

    public void removePlaylist(String id);

    public Set<Song> getLikedSongs();

    public Set<Playlist> getLikedPlaylists();

    public Boolean likedSong(String id);
}