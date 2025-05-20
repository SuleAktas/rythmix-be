package com.suleaktasyazan.RythmixBE.service.impl;

import com.suleaktasyazan.RythmixBE.dto.DTOPlaylist;
import com.suleaktasyazan.RythmixBE.dto.DTOPlaylistWithSongs;
import com.suleaktasyazan.RythmixBE.dto.DTOSong;
import com.suleaktasyazan.RythmixBE.entity.Playlist;
import com.suleaktasyazan.RythmixBE.entity.Song;
import com.suleaktasyazan.RythmixBE.entity.User;
import com.suleaktasyazan.RythmixBE.repository.*;
import com.suleaktasyazan.RythmixBE.service.IPlaylistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements IPlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<DTOPlaylist> getAllPlaylists() {
        List<Playlist> playlistList= playlistRepository.findRandom10Playlists();
        List<DTOPlaylist> dtoPlaylists = new ArrayList<>();
        for(Playlist playlist : playlistList){
            DTOPlaylist dtoPlaylist = new DTOPlaylist();
            BeanUtils.copyProperties(playlist,dtoPlaylist);
            dtoPlaylists.add(dtoPlaylist);
        }
        return dtoPlaylists;
    }

    @Override
    public Playlist getPlaylist(String id) {
        Optional<Playlist> optionalPlaylist= playlistRepository.findById(id);
        if(optionalPlaylist.isPresent()){
            return optionalPlaylist.get();
        }

        return null;
    }

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public DTOPlaylistWithSongs getSongsByPlaylistId(String id) {
        DTOPlaylistWithSongs dtoPlaylistWithSongsList = new DTOPlaylistWithSongs();

        Optional<Playlist> playlist = playlistRepository.findById(id);

        BeanUtils.copyProperties(playlist.get(),dtoPlaylistWithSongsList);


        User user = userRepository.findFirstByOrderByIdAsc();

        Set<String> likedSongIds = user.getLikedSongs().stream()
                .map(Song::getId)
                .collect(Collectors.toSet());

        Set<String> likedPlaylistIds = user.getLikedPlaylists().stream()
                .map(Playlist::getId)
                .collect(Collectors.toSet());
        dtoPlaylistWithSongsList.setIsLiked(likedPlaylistIds.contains(id));

        String singerName = "";
        String albumImage = "";
        if(playlist.isPresent()){
            singerName = playlist.get().getSinger().getName();
            albumImage = playlist.get().getImageUrl();
        }
        List<DTOSong> dtoSongList = new ArrayList<>();
        List<Song> songList = playlistRepository.findByPlaylistId(id);
        for(Song song : songList){
            DTOSong dtoSong = new DTOSong();
            BeanUtils.copyProperties(song,dtoSong);
            dtoSong.setAlbumImageUrl(albumImage);
            dtoSong.setSingerName(singerName);
            dtoSong.setIsLiked(likedSongIds.contains(song.getId()));
            dtoSongList.add(dtoSong);
        }
        dtoPlaylistWithSongsList.setSingerName(singerName);
        dtoPlaylistWithSongsList.setSongList(dtoSongList);
        return dtoPlaylistWithSongsList;

    }



}
