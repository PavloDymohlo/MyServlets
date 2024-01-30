<%@ page contentType="text/html" language="java" %>
<html>
<head>
<title>Calculate Page</title>
</head>

<body>
<h1>Calculate Page</h1>

<form action="calculatorServlet" method="post">
<label for="firstOperand">Enter number 1: </label>
<input type="text" id="firstOperand" name="firstOperand" required>
<label for="operation">Choose operation: </label>

<select id="operation" name="operation">
<option value="add">Addition</option>
<option value="subtraction">Subtraction</option>
<option value="multiply">Multiplication</option>
<option value="divide">Division</option>
</select>

<label for="secondOperand">Enter number 2: </label>
<input type="text" id="secondOperand" name="secondOperand" required>
<button type="submit">Calculate</button>
</form>

<div>
<c:if test="&{not empty param.result}">
<p>Result: ${param.result}</p>
</c:if>
</div>
</body>

</html>