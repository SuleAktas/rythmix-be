package com.suleaktasyazan.RythmixBE.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOPlaylistWithSongs {

    private String id;

    private String name;

    private String imageUrl;

    private String singerName;

    private Boolean isLiked;

    List<DTOSong> songList;
}
