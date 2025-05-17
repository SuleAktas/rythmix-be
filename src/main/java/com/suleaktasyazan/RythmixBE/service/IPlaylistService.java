package com.suleaktasyazan.RythmixBE.service;

import com.suleaktasyazan.RythmixBE.dto.DTOPlaylist;
import com.suleaktasyazan.RythmixBE.dto.DTOSong;
import com.suleaktasyazan.RythmixBE.entity.Playlist;

import java.util.List;

public interface IPlaylistService {
    public List<DTOPlaylist> getAllPlaylists();

    public Playlist getPlaylist(String id);

    public Playlist createPlaylist(Playlist playlist);


    public List<DTOSong> getSongsByPlaylistId(String id);

}
