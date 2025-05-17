package com.suleaktasyazan.RythmixBE.service.impl;

import com.suleaktasyazan.RythmixBE.dto.DTOPlaylist;
import com.suleaktasyazan.RythmixBE.dto.DTOSong;
import com.suleaktasyazan.RythmixBE.entity.Playlist;
import com.suleaktasyazan.RythmixBE.entity.Song;
import com.suleaktasyazan.RythmixBE.repository.PlaylistRepository;
import com.suleaktasyazan.RythmixBE.repository.PlaylistTypeRepository;
import com.suleaktasyazan.RythmixBE.repository.SingerRepository;
import com.suleaktasyazan.RythmixBE.repository.SongRepository;
import com.suleaktasyazan.RythmixBE.service.IPlaylistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements IPlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;


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
    public List<DTOSong> getSongsByPlaylistId(String id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
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
            dtoSongList.add(dtoSong);
        }
        return dtoSongList;
    }


}
