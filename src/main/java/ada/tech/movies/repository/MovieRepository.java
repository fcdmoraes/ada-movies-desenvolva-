package ada.tech.movies.repository;

import ada.tech.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {

    //QUERY METHOD
    List<Movie> findByGenre(String genre);

    //JAVA PERSISTENCE QUERY LANGUAGE
    @Query("""
      SELECT m
      FROM Movie m
      WHERE m.genre = :genre
     """)
    List<Movie> findByGenreByJPQL(@Param("genre") String genre);

    //NATIVE QUERY
    @Query(value = """
    SELECT m.*
    FROM movie as m
    WHERE m.genre = :genre
    """, nativeQuery = true)
    List<Movie> findByGenreNative(String genre);


    //JAVA PERSISTENCE QUERY LANGUAGE
    @Query("""
      SELECT m
      FROM Movie m
      WHERE (:genre is null or m.genre = :genre)
           AND (:releaseDate is null or m.releaseDate = :releaseDate)
                AND (:title is null or m.title = :title)
                     and (:imageUrl is null or m.imageUrl = :imageUrl)
                          and (:description is null or m.description = :description)
     """)
    List<Movie> findByParamsByJPQL(@Param("genre") String genre,
                                   @Param("releaseDate") String releaseDate,
                                   @Param("title") String title,
                                   @Param("description") String description,
                                   @Param("imageUrl") String imageUrl);
}
