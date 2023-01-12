package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.mapper.SongsMapper;
import org.apache.ibatis.javassist.NotFoundException;
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
    public Optional<Songs> findById(int year) throws NotFoundException {
        Optional<Songs> songs = songsMapper.findById(year);
        if (!songs.isPresent()){
            String errorMessage = year + "年の曲は存在しません";
            throw new NotFoundException(errorMessage);
        }
        return songsMapper.findById(year);
    }
}
