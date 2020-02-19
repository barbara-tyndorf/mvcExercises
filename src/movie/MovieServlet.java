package movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/movie")
public class MovieServlet extends HttpServlet {

    private final MovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> availableMovies = movieService.getMovies();
        req.setAttribute("availableMovies", availableMovies);
        req.getRequestDispatcher("movie_no_jstl.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String type = req.getParameter("type");
        Movie movie = new Movie(title, type);
        movieService.add(movie);
        req.getRequestDispatcher("movie_add.jsp").forward(req, resp);
    }
}
