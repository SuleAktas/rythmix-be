package com.suleaktasyazan.RythmixBE.service.impl;

import com.suleaktasyazan.RythmixBE.entity.Singer;
import com.suleaktasyazan.RythmixBE.repository.SingerRepository;
import com.suleaktasyazan.RythmixBE.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingerServiceImpl implements ISingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public List<Singer> getAllSingers() {
        return singerRepository.findAll();
    }

    @Override
    public Singer getSinger(String id) {
        Optional<Singer> singerOptional =  singerRepository.findById(id);
        if(singerOptional.isPresent()){
            return singerOptional.get();
        }
        return null;
    }


}
