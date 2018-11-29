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
	<table border="2">
		<tr><th>Minutes</th><th>Exercise Minutes</th><th>Activity</th></tr>

		<c:forEach items="${goalReports}" var="aGoalReport">
			<tr>
				<td>${aGoalReport.goalMinutes}</td>
				<td>${aGoalReport.exerciseMinutes}</td>
				<td>${aGoalReport.exerciseActivity}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>