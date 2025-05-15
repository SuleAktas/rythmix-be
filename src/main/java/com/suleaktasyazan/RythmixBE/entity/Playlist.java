package com.suleaktasyazan.RythmixBE.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Playlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name="image_url",nullable = false)
    private String imageUrl;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;

    @ManyToOne
    private PlaylistType type;


    @ManyToOne
    private Singer singer;

    @ManyToMany
    @JoinTable(name = "Playlist_Song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name="song_id"))
    private List<Song> songs;

}
