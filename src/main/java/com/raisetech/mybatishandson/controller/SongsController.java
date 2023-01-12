package com.raisetech.mybatishandson.controller;

import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.service.SongsService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SongsController {
    private final SongsService songsService;

    public SongsController(SongsService songsService) {
        this.songsService = songsService;
    }
    @GetMapping("/songs")
    public List<Songs> getTitles(){
        return songsService.findAll().stream().toList();
    }
    @GetMapping("/songs")
    public Optional<Songs> getSongsList(@RequestParam("published_year") int published_year){
        return songsService.findById(published_year);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NotFoundException.class })
    @ResponseBody
    public Map<String, Object> handleError(){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("message", "見つかりません");
        errorMap.put("status", HttpStatus.NOT_FOUND0);
        return errorMap;
    }

}
