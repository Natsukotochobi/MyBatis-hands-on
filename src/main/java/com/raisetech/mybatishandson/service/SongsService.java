package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.entity.Songs;

import java.util.List;
import java.util.Optional;


public interface SongsService {
    List<Songs> findAll();

    Optional<Songs> findById(int year) throws Exception;
}
