package ada.tech.movies.specification;

import ada.tech.movies.model.Movie;
import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification {
    public static Specification<Movie> hasGenre(String genre) {
        return (root, query, cb) ->
                (genre == null)
                        ? null
                        : cb.equal(root.get("genre"), genre);
    }
    public static Specification<Movie> hasReleaseDate(String date) {
        return (root, query, cb) ->
                (date == null)
                        ? null
                        : cb.equal(root.get("releaseDate"), date);
    }
    public static Specification<Movie> hasTitle(String  title) {
        return (root, query, cb) ->
                (title == null)
                        ? null
                        : cb.equal(root.get("title"), title);
    }
    public static Specification<Movie> hasDescription(String description) {
        return (root, query, cb) ->
                (description == null)
                        ? null
                        : cb.equal(root.get("description"), description);
    }
    public static Specification<Movie> hasImageUrl(String imageUrl) {
        return (root, query, cb) ->
                (imageUrl == null)
                        ? null
                        : cb.equal(root.get("imageUrl"), imageUrl);
    }
}
