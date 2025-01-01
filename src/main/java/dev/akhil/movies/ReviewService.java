package dev.akhil.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {

        Review review = reviewRepository.insert(new Review(reviewBody));


        // using a mongo template instead of a repo
        mongoTemplate.update(Movie.class)     // updating the movie (as of rn, each movie contains an empty array of reviews)
                .matching(Criteria.where("imdbId").is(imdbId))  // finding the correct movie by checking the imdbId passed in vs the imdbId in our api
                .apply(new Update().push("reviewIds").value(review)) // updating the reviews array of the movie class, associated with the imdbId, with the actual review body
                .first();  // makes sure that we're getting a single movie

        return review;
    }

}
