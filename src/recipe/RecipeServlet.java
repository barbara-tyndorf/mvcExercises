package recipe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@WebServlet("/recipe")
public class RecipeServlet extends HttpServlet {

    private final RecipeService recipeService = new RecipeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("name", req.getParameter("name"));
        params.put("numberOfPeople", req.getParameter("numberOfPeople"));
        List<Recipe> recipes = recipeService.getRecipes(params);
        req.setAttribute("availableRecipes", recipes);
        req.getRequestDispatcher("recipe_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder output = new StringBuilder();
        String name = req.getParameter("name");
        String ingredients = req.getParameter("ingredients");
        int prepareTime = Integer.parseInt(req.getParameter("prepareTime"));
        int calories = Integer.parseInt(req.getParameter("calories"));
        int numberOfPeople = Integer.parseInt(req.getParameter("numberOfPeople"));

        Recipe recipe = new Recipe(new Random().nextInt(), name, ingredients, prepareTime, calories, numberOfPeople);
        recipeService.addRecipe(recipe);

        RequestDispatcher invalidDataRequestDispatcher = req.getRequestDispatcher("add_recipe.html");
        RequestDispatcher validDataRequestDispatcher = req.getRequestDispatcher("recipe_add.jsp");

        recipeService.validateName(name, output);
        recipeService.validatePrepareTime(prepareTime, output);
        recipeService.validateCalories(calories, output);
        recipeService.validateNumberOfPeople(numberOfPeople, output);

        if(output.toString().isEmpty()) {
            validDataRequestDispatcher.forward(req, resp);
        } else {
            resp.getWriter().println(output);
            invalidDataRequestDispatcher.include(req, resp);
        }
    }
}
