package recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecipeService {

    private final List<Recipe> recipes = new ArrayList<>();

    public Recipe addRecipe(Recipe recipe) {
        recipes.add(recipe);
        return recipe;
    }

    public List<Recipe> getRecipes(Map<String, String> params) {
        if (params.isEmpty()) {
            return recipes;
        }
        List<Recipe> filteredList = recipes;
        if (params.get("name") != null) {
            filteredList = findByName(
                    params.getOrDefault("name", "unknown"));
        }
        if (params.get("numberOfPeople") != null) {
            filteredList = findByNumberOfPeople(
                    Integer.parseInt(params.getOrDefault("numberOfPeople", "-1")));
        }

        return filteredList;
    }

    public List<Recipe> findByName(String name) {
        List<Recipe> filteredList = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(name)) {
                filteredList.add(recipe);
            }
        }
        return filteredList;
    }

    public List<Recipe> findByNumberOfPeople(int numberOfPeople) {
        List<Recipe> filteredList = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getNumberOfPeople() == numberOfPeople) {
                filteredList.add(recipe);
            }
        }
        return filteredList;
    }

    public void validateName(String name, StringBuilder output) {
        if (name.isEmpty()) {
            output.append("<p>Podaj nazwę przepisu!<br></p>");
        }
    }

    public void validatePrepareTime(int prepareTime, StringBuilder output) {
        String time = String.valueOf(prepareTime);
        for (int i = 0; i < time.length(); i++) {
            if (!Character.isDigit(time.charAt(i))) {
                output.append("<p>Podaj czas przygotowania potrawy w minutach!br></p>");
            }
        }
        if (!(prepareTime >= 15 && prepareTime <= 300)) {
            output.append("<p>Podaj czas przygotowania potrawy w minutach!br></p>");
        }
    }

    public void validateCalories(int calories, StringBuilder output) {
        String cal = String.valueOf(calories);
        for (int i = 0; i < cal.length(); i++) {
            if (!Character.isDigit(cal.charAt(i))) {
                output.append("<p>Invalid input!br></p>");
            }
        }
        if (!(calories >= 200 && calories <= 10000)) {
            output.append("<p>Invalid input! Please enter calories in the range from 200 to 10000 cal.<br></p>");
        }
    }

        public void validateNumberOfPeople (int numberOfPeople, StringBuilder output) {
            String num = String.valueOf(numberOfPeople);
            for (int i = 0; i < num.length(); i++) {
                if (!Character.isDigit(num.charAt(i))) {
                    output.append("<p>Invalid input!br></p>");
                }
            }
            if (!(numberOfPeople > 0 && numberOfPeople <= 6)) {
                output.append("<p>Invalid input! Please enter number of people for dish in the range from 1 to 6.<br></p>");
            }
        }
}
