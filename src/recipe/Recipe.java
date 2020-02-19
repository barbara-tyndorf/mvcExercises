package recipe;


public class Recipe {
    int id;
    String name;
    String ingredients;
    int prepareTime;
    int calories;
    int numberOfPeople;

    public Recipe(int id, String name, String ingredients, int prepareTime, int calories, int numberOfPeople) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.prepareTime = prepareTime;
        this.calories = calories;
        this.numberOfPeople = numberOfPeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(int prepareTime) {
        this.prepareTime = prepareTime;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", prepareTime=" + prepareTime +
                ", calories=" + calories +
                ", forPersons=" + numberOfPeople +
                '}';
    }
}
