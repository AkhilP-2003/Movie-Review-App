package dev.akhil.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // all the rest api requets
@RequestMapping("/api/v1/movies") // sets the url endpoint
public class MovieController {

    @Autowired // enables dependency injection for you (rmbr DI allows an obj to receive other objs instead of creating them manually
    private MovieService movieService;

    @GetMapping // get request
    public ResponseEntity<List<Movie>> getAllMovies(){

        // response entity obj allows us to include the response and the http status code

        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);

    }

    @GetMapping("/{imdbId}") // takes in id as a param from the url
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){

        // returns the data for a specific movie (we include optional to see if the movie id is even found)
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);

    }

}
