<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting Page</title>
</head>
<body>
    <h1>Greeting Page</h1>

    <form action="greet" method="get">
        <label for="name">Enter your name: </label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Greet</button>
    </form>

    <div>
        <c:if test="${not empty param.name}">
            <p></p>
        </c:if>
    </div>
</body>
</html>




