package ada.tech.movies.controller;

import ada.tech.movies.model.Movie;
import ada.tech.movies.repository.MovieRepository;
import ada.tech.movies.specification.MovieSpecification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam(required = false) String genre,
                                 @RequestParam(required = false) String release_data,
                                 @RequestParam(required = false) String title,
                                 @RequestParam(required = false) String description,
                                 @RequestParam(required = false) String imageUrl) {
//        return movieRepository.findByParamsByJPQL(genre, release_data, title, description, imageUrl);
        return movieRepository.findAll(
                MovieSpecification.hasGenre(genre)
                        .and(MovieSpecification.hasDescription(description))
                        .and(MovieSpecification.hasImageUrl(imageUrl))
                        .and(MovieSpecification.hasTitle(title))
                        .and(MovieSpecification.hasReleaseDate(release_data))
        );
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }


}

