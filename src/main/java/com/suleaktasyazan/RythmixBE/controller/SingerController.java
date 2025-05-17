package com.suleaktasyazan.RythmixBE.controller;

import com.suleaktasyazan.RythmixBE.entity.Singer;
import com.suleaktasyazan.RythmixBE.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/singer")

public class SingerController {

    @Autowired
    private ISingerService singerService;

    @GetMapping
    public List<Singer> getAllSingers(){
        return singerService.getAllSingers();
    }

    @GetMapping(path = "/{id}")
    public Singer getSinger(@PathVariable(name = "id") String id){
        return singerService.getSinger(id);
    }

}
