package com.suleaktasyazan.RythmixBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Song")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long duration;

    @Column(name="image_url",nullable = false)
    private String imageUrl;

    @Column(name="audio_url",nullable = false)
    private String audioUrl;


    @Column(name = "created_date",nullable = false)
    private Date createdDate;

    @ManyToOne
    private Singer singer;
}
