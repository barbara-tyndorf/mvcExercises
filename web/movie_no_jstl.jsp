<%@ page import="java.util.List" %>
<%@ page import="movie.Movie" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Movies Page</title>
</head>
<body>

<table id="messages" border="1">
    <tr>
        <th>Title</th>
        <th>Type</th>
    </tr>

    <%
        List<Movie> movies = (List<Movie>) request.getAttribute("availableMovies");
        for(Movie movie : movies){
            out.println("<tr>");
            out.println(String.format("<td>%s</td>", movie.getTitle()));
            out.println(String.format("<td>%s</td>", movie.getType()));
            out.println("</tr>");
        }
    %>
</table>
</body>
</html>