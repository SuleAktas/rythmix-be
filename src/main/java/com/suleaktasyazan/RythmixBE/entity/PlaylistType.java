package com.suleaktasyazan.RythmixBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="PlaylistType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name = "created_date",nullable = false)
    private Date createdDate;


}
