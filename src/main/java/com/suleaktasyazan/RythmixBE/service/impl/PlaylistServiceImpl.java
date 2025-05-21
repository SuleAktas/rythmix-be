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
        DTOPlaylistWithSongs dto = new DTOPlaylistWithSongs();
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);

        if (optionalPlaylist.isEmpty()) {
            throw new NoSuchElementException("Playlist not found with id: " + id);
        }

        Playlist playlist = optionalPlaylist.get();
        BeanUtils.copyProperties(playlist, dto);

        User user = userRepository.findFirstByOrderByIdAsc();
        String typeId = playlist.getType().getId();
        String singerName = playlist.getSinger().getName();
        String albumImage = playlist.getImageUrl();

        dto.setSingerName(singerName);

        if (isLikedSongsPlaylist(typeId)) {
            List<DTOSong> likedSongs = mapSongs(user.getLikedSongs(), true, albumImage);
            dto.setSongList(likedSongs);
            return dto;
        }

        dto.setIsLiked(user.getLikedPlaylists().stream()
                .anyMatch(p -> p.getId().equals(id)));

        Set<String> likedSongIds = user.getLikedSongs().stream()
                .map(Song::getId)
                .collect(Collectors.toSet());

        List<Song> songs = playlistRepository.findByPlaylistId(id);
        List<DTOSong> dtoSongs = songs.stream()
                .map(song -> mapSong(song, likedSongIds.contains(song.getId()), albumImage))
                .collect(Collectors.toList());

        dto.setSongList(dtoSongs);
        return dto;
    }

    private boolean isLikedSongsPlaylist(String typeId) {
        return "631422ff-9473-468d-b267-f63a5272181c".equals(typeId);
    }

    private List<DTOSong> mapSongs(Set<Song> songs, boolean isLiked, String albumImage) {
        return songs.stream()
                .map(song -> mapSong(song, isLiked, albumImage))
                .collect(Collectors.toList());
    }

    private DTOSong mapSong(Song song, boolean isLiked, String albumImage) {
        DTOSong dtoSong = new DTOSong();
        BeanUtils.copyProperties(song, dtoSong);
        dtoSong.setIsLiked(isLiked);
        dtoSong.setAlbumImageUrl(albumImage);
        dtoSong.setSingerName(song.getSinger().getName());
        return dtoSong;
    }


}
