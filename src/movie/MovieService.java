package movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

}
