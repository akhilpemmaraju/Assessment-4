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
	<div class="form-row">
		<div class="form-group col-md-6">
		
			Enter ID:<input type="number" name="id" />
		</div>
		<div class="form-group col-md-6">
			Enter Title:<input type="text" name="title" />
		</div>
		<div class="form-group col-md-6">
			Enter City:<input type="number" name="city" />
		</div>
		<div class="form-group col-md-6">
			Enter Zip:<input type="text" name="zip" />
		</div>
		<div class="form-group col-md-6">
			Enter Desc:<input type="text" name="desc" />
		</div>
		<div class="form-group col-md-6">
			Enter email:<input type="text" name="email" />
		</div>
		<div class="form-group col-md-6">
			Enter phone:<input type="text" name="phone" />
		</div>
		<input class="btn btn-primary" type="submit" name="viewads" value="Add details" />
</form>
<hr>
	<table border="1">
		<thead>
		<td>ID</td>
		<td>Category</td>
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
		<td>${ad.cat}</td>
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