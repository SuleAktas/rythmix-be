package com.suleaktasyazan.RythmixBE.service.impl;

import com.suleaktasyazan.RythmixBE.dto.DTOPlaylistType;
import com.suleaktasyazan.RythmixBE.entity.PlaylistType;
import com.suleaktasyazan.RythmixBE.repository.PlaylistTypeRepository;
import com.suleaktasyazan.RythmixBE.service.IPlaylistTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PlaylistTypeServiceImpl implements IPlaylistTypeService {

    @Autowired
    private PlaylistTypeRepository playlistTypeRepository;


    @Override
    public PlaylistType getPlaylistType(String id) {
        return null;
    }

    @Override
    public PlaylistType createPlaylistType(DTOPlaylistType dtoPlaylistType) {
        PlaylistType playlistType = new PlaylistType();
        BeanUtils.copyProperties(dtoPlaylistType,playlistType);
        playlistType.setCreatedDate(new Date());
        playlistTypeRepository.save(playlistType);
        return playlistType;
    }

}
