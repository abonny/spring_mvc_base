<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goals Report</title>
</head>
<body>

	<table border="3">
		<tr><th>ID</th><th>Minutes</th><th>Exercises</th></tr>

		<c:forEach items="${goals}" var="aGoal">
			<tr>
				<td>${aGoal.id}</td>
				<td>${aGoal.minutes}</td>
				
				<td>
					<table border="1">
						<tr><th>Exercise ID</th><th>Exercise Minutes</th><th>Exercise Activity</th></tr>
						<c:forEach items="${aGoal.exercises}" var="aExercise">
							<tr><td>${aExercise.id}</td><td>${aExercise.minutes}</td><td>${aExercise.activity}</td></tr>
						</c:forEach>
					</table>
				</td>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>