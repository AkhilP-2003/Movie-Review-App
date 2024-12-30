package dev.akhil.movies;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// the document annotation tells spring that this class is mapped to a MOngoDB collection (it tells spring that the
// Movie classMongoDB document (json obj) and Movie instances should be mapped to the "movies" collecxtion
@Document(collection = "movies")
@Data  // cmes from the lombok library and it takes care of all the getters setters, etc methods
@AllArgsConstructor // annoation that takes all of these private fields as args in our constructor
@NoArgsConstructor // constructor that takes no args

// creating a movie class to store the movie info
public class Movie {

    @Id // lets spring know that ObjectID should be treated as a unique identifier for our db
    private ObjectId id; // represents the id of the movie

    private String imdbId; // represents the imdb id of the movie

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference   // this will cause the db to store the id of the reviews and the reviews will be in a seperate
                         // collection
    private List<Review> reviewIds;

}
