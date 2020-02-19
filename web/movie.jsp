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

    <c:forEach items="${requestScope.availableMovies}" var="movie">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.type}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>