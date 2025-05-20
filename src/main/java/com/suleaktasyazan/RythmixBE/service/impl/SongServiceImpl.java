package com.suleaktasyazan.RythmixBE.service.impl;

import com.suleaktasyazan.RythmixBE.dto.DTOSong;
import com.suleaktasyazan.RythmixBE.entity.*;
import com.suleaktasyazan.RythmixBE.repository.*;
import com.suleaktasyazan.RythmixBE.service.ISongService;
import com.suleaktasyazan.RythmixBE.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistTypeRepository playlistTypeRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

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

    @Override
    public Song likeSong(String id) {
        Optional<Playlist> playlistOptional = playlistRepository.findByTypeId("631422ff-9473-468d-b267-f63a5272181c");
        Playlist playlist = new Playlist();
        if(playlistOptional.isPresent()){
            playlist = playlistOptional.get();
        }
        else{
            Optional<PlaylistType> optionalPlaylistType = playlistTypeRepository.findById("631422ff-9473-468d-b267-f63a5272181c");
            if(optionalPlaylistType.isPresent()){
                playlist.setType(optionalPlaylistType.get());
            }
            playlist.setName("Beğenilen Şarkılar");
            playlist.setSinger(new Singer());
            playlist.setCreatedDate(new Date());
            playlist.setSongs(new ArrayList<Song>());
            playlist.setImageUrl("");
            playlistRepository.save(playlist);
        }
        Optional<Song> songOptional = songRepository.findById(id);
        if(songOptional.isPresent()){
            playlist.getSongs().add(songOptional.get());
            playlist.setSongs(playlist.getSongs());
        }

        return songOptional.get();
    }

    @Override
    public List<DTOSong> getFilteredSongs(String query) {
        List<DTOSong> dtoSongList = new ArrayList<>();
        List<Song> songList = songRepository.findByNameContainingIgnoreCase(query);
        for(Song song : songList){
            DTOSong dtoSong = new DTOSong();
            BeanUtils.copyProperties(song,dtoSong);
            dtoSong.setSingerName(song.getSinger().getName());
            dtoSong.setIsLiked(userService.likedSong(song.getId()));
            dtoSongList.add(dtoSong);
        }


        return dtoSongList;
    }


}
