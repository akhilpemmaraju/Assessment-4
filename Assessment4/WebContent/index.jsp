<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" />
<title>YourAd</title>
</head>
<body>
<h1>YourAd</h1>
	<form action="FetchDataServlet" method="post">
		<div class="form-group">	
			<label for="exampleFormControlSelect1">Select Category of Ad:</label>
			<select class="form-control" id="exampleFormControlSelect1">			
				<option value="Jobs" name="cat">Jobs</option>
				<option value="Housing" name="cat">Housing</option>
				<option value="Sale" name="cat">Sale</option>
				<option value="Services" name="cat">Services</option>
				<option value="Events" name="cat">Events</option>			
			</select>
		</div>
		<input class="btn btn-primary" type="button" value="Continue" name="NewForm" onclick="openPage('details.jsp')"/>
	</form>
	<script type="text/javascript">
 		function openPage(pageURL)
 		{
 		window.location.href = pageURL;
 		}
	</script>
	<hr>
	<table border="1">
		<thead>
		<td>ID</td>
		<td>Title</td>
		<td>City</td>
		<td>Zip</td>
		<td>Description</td>
		<td>Email</td>
		<td>Phone</td>
		</thead>
		<c:forEach var="ad" items="${list}">
		<tr>
		<td>${ad.id}</td>
		<td>${ad.title}</td>
		<td>${ad.city}</td>
		<td>${ad.zip}</td>
		<td>${ad.desc}</td>
		<td>${ad.email}</td>
		<td>${ad.phone}</td>
		</tr>
		</c:forEach>		
	</table>	
</body>
</html>