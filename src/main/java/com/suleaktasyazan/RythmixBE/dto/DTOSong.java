package com.suleaktasyazan.RythmixBE.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOSong {

    private String id;

    private String name;

    private Long duration;

    private String imageUrl;

    private String audioUrl;

    private String albumImageUrl;

    private String singerName;
}
