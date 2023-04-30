package com.favAnime.demo.controller;

import com.favAnime.demo.exception.InformationExistException;
import com.favAnime.demo.exception.InformationNotFoundException;
import com.favAnime.demo.model.Genre;
import com.favAnime.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotated with @ResponseBody; return object in JSON
@RequestMapping(path = "/api")
public class GenreController {

    private GenreService genreService;

    @Autowired // setter-based dependency injection creates an instance of GenreService
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    // GET all genres endpoint
    // http://localhost:9090/api/genres
    @GetMapping(path = "/genres")
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }

    // GET specific genre endpoint
    // http://localhost:9090/api/genres/1
    @GetMapping(path = "/genres/{genreId}")
    public Genre getGenreById(@PathVariable Long genreId) {
        return genreService.getGenreById(genreId);
    }

    // POST add genre endpoint
    // http://localhost:9090/api/genres
    @PostMapping(path = "/genres")
    public Genre createGenre(@RequestBody Genre genreObject) {
        return genreService.createGenre(genreObject);
    }

    // PUT update specific genre endpoint
    // http://localhost:9090/api/genres/1
    @PutMapping(path = "/genres/{genreId}")
    public Genre updateGenre(@PathVariable Long genreId, @RequestBody Genre genreObject) {
        return genreService.updateGenre(genreId, genreObject);
    }

    // DELETE specific endpoint
    // http://localhost:9090/api/genres/1
    @DeleteMapping(path = "/genres/{genreId}")
    public Genre deleteGenre(@PathVariable Long genreId) {
        return genreService.deleteGenre(genreId);
    }
}
