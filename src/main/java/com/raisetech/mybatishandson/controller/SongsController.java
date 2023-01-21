package com.raisetech.mybatishandson.controller;

import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.exception.ResourceNotFoundException;
import com.raisetech.mybatishandson.service.SongsService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
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
    public List<Songs> getTitles() {
        return songsService.findAll().stream().toList();
    }

    @GetMapping("/songs/{published_year}")
    public Optional<Songs> getSongsList(@PathVariable("published_year") int published_year){
        return this.songsService.findSongsInfo(published_year);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timeStamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
}
