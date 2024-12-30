package dev.akhil.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    // inside this class we have to write the database access methods

    @Autowired // when a class needs another class (in our case we need movierepo class for our movieservice class), autowired allows spring to find the required bean and inject it
    // a bean is an object that spring manages (it manageds all the object in an application context like a container)
    private MovieRepository movieRepository; // we need a reference to the movie repo

    public List<Movie> allMovies() {

        return movieRepository.findAll(); //findall method is from the mongorepository class
    }

    public Optional<Movie> singleMovie(ObjectId id) {

        // searches thru the db to find by id, which is passed in as a param
        return movieRepository.findById(id);
    }
}
