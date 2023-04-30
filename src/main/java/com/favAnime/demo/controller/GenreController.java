package com.favAnime.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController // annotated with @ResponseBody; return object in JSON
@RequestMapping(path = "/api")
public class GenreController {

    // sample GET endpoint
    // http://localhost:9090/api/genres
    @GetMapping(path = "/genres")
    public String getGenres() {
        return "get all genres";
    }

    // sample GET endpoint
    // http://localhost:9090/api/genres/1
    @GetMapping(path = "/genres/{genreId}")
    public String getGenreById(@PathVariable Long genreId) {
        return "get genre with Id " + genreId;
    }

    // sample POST endpoint
    // http://localhost:9090/api/genres
    @PostMapping(path = "/genres")
    public String createGenre(@RequestBody String body) {
        return "creating a new genre with " + body;
    }
}
