package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.mapper.SongsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongsServiceImpl implements SongsService {
    private SongsMapper songsMapper;

    public SongsServiceImpl(SongsMapper songsMapper) {
        this.songsMapper = songsMapper;
    }

    @Override
    public List<Songs> findAll() {
        return songsMapper.findAll();
    }

    @Override
    public Optional<Songs> findById(int year){
        return songsMapper.findById(year);
    }
}
