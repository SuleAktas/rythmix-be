package com.suleaktasyazan.RythmixBE.service.impl;

import com.suleaktasyazan.RythmixBE.entity.Playlist;
import com.suleaktasyazan.RythmixBE.entity.Song;
import com.suleaktasyazan.RythmixBE.entity.User;
import com.suleaktasyazan.RythmixBE.repository.PlaylistRepository;
import com.suleaktasyazan.RythmixBE.repository.SongRepository;
import com.suleaktasyazan.RythmixBE.repository.UserRepository;
import com.suleaktasyazan.RythmixBE.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserSeviceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Set<Song> getLikedSongs() {
        return userRepository.findFirstByOrderByIdAsc().getLikedSongs();
    }

    @Override
    public Set<Playlist> getLikedPlaylists() {
        return userRepository.findFirstByOrderByIdAsc().getLikedPlaylists();
    }

    @Override
    public Boolean likedSong(String id) {
        Optional<Song> song = songRepository.findById(id);
        return userRepository.findFirstByOrderByIdAsc().getLikedSongs().contains(song.get());
    }


    @Override
    public void likeSong(String id) {
        Set<Song> songList = new HashSet<>();
        User user = userRepository.findFirstByOrderByIdAsc();
        Optional<Song> optionalSong = songRepository.findById(id);
        songList = user.getLikedSongs();
        songList.add(optionalSong.get());
        user.setLikedSongs(songList);
        userRepository.save(user);
    }

    @Override
    public void likePlaylist(String id) {
        Set<Playlist> playlistSet = new HashSet<>();
        User user = userRepository.findFirstByOrderByIdAsc();
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        playlistSet = user.getLikedPlaylists();
        playlistSet.add(optionalPlaylist.get());
        user.setLikedPlaylists(playlistSet);
        userRepository.save(user);
    }
    @Override
    public void removeSong(String id) {
        Set<Song> songList = new HashSet<>();
        User user = userRepository.findFirstByOrderByIdAsc();
        Optional<Song> optionalSong = songRepository.findById(id);
        songList = user.getLikedSongs();
        songList.remove(optionalSong.get());
        user.setLikedSongs(songList);
        userRepository.save(user);
    }
    @Override
    public void removePlaylist(String id) {
        Set<Playlist> playlistSet = new HashSet<>();
        User user = userRepository.findFirstByOrderByIdAsc();
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        playlistSet = user.getLikedPlaylists();
        playlistSet.remove(optionalPlaylist.get());
        user.setLikedPlaylists(playlistSet);
        userRepository.save(user);
    }
}
