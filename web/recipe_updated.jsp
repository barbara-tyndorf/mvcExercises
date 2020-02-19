<%@ page import="java.util.List" %>
<%@ page import="recipe.Recipe" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Recipe updated</title>
</head>
<body>

<%
    out.println("Recipe updated successfully!");
%>

<table id="messages" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Ingredients</th>
        <th>Prepare time</th>
        <th>Calories</th>
        <th>Number of Persons</th>
    </tr>

    <%
        Recipe recipe = (Recipe) request.getAttribute("recipe");
            out.println("<tr>");
            out.println(String.format("<td>%s</td>", recipe.getId()));
            out.println(String.format("<td>%s</td>", recipe.getName()));
            out.println(String.format("<td>%s</td>", recipe.getIngredients()));
            out.println(String.format("<td>%s</td>", recipe.getPrepareTime()));
            out.println(String.format("<td>%s</td>", recipe.getCalories()));
            out.println(String.format("<td>%s</td>", recipe.getNumberOfPeople()));
            out.println("</tr>");
    %>
</table>
</body>
</html>