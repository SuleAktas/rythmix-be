package com.suleaktasyazan.RythmixBE.service;

import com.suleaktasyazan.RythmixBE.dto.DTOPlaylist;
import com.suleaktasyazan.RythmixBE.dto.DTOPlaylistWithSongs;
import com.suleaktasyazan.RythmixBE.entity.Playlist;

import java.util.List;

public interface IPlaylistService {
    public List<DTOPlaylist> getAllPlaylists();

    public Playlist getPlaylist(String id);

    public Playlist createPlaylist(Playlist playlist);


    public DTOPlaylistWithSongs getSongsByPlaylistId(String id);

}
