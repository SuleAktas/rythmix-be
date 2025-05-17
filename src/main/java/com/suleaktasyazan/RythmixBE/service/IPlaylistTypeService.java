package com.suleaktasyazan.RythmixBE.service;

import com.suleaktasyazan.RythmixBE.dto.DTOPlaylistType;
import com.suleaktasyazan.RythmixBE.entity.PlaylistType;

import java.util.List;

public interface IPlaylistTypeService {


    public PlaylistType getPlaylistType(String id);

    public PlaylistType createPlaylistType(DTOPlaylistType dtoPlaylistType);

}
