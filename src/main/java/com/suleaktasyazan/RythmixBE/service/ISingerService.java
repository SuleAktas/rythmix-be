package com.suleaktasyazan.RythmixBE.service;

import com.suleaktasyazan.RythmixBE.entity.Singer;

import java.util.List;

public interface ISingerService {
    public List<Singer> getAllSingers();

    public Singer getSinger(String id);

}
