<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//eğer bir oyorum yoksa  login sayfasına yönlendir
	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	}

	String userName = (String) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<meta charset="UTF-8">
<title>CRUD | Üye List/Ekleme</title>

<!--styles-->
<link rel="stylesheet" href="assets/styles/main.css">
<link rel="stylesheet" href="assets/styles/bootstrap.css">
<!--scripts-->
<script src="assets/scripts/jquery-1.12.2.min.js"></script>
<script src="https://cdn.ckeditor.com/4.5.7/basic/ckeditor.js"></script>
<script src="assets/scripts/admin.js"></script>

</head>
<body>

	<!--navbar-->
	<%@ include file="header.jsp"%>
	<!--sidebar-->
	<%@ include file="sidebar.jsp"%>
	<!--content-->
	<div class="content">

		<div class="box-container">
			<div class="box" id="div-0">
				<h3>CRUD Example</h3>
				<div class="box-content">
					<p>Welcome Basic Blog (Author:Dervish)</p>
				</div>
			</div>
		</div>


		<div class="box-container container-25">
			<div class="box" id="div-1">
				<h3>User Düzenle</h3>
				<div class="box-content">
					<form action=User method="post" class="form">
						<ul>
						<input type="hidden" name="islem"
								value="duzenle">
								<input type="hidden" name="id" value="<c:out value="${user.id}" />">
							<li><input type="text" name="username" value="${user.username}"	placeholder="username"></li>
							<li><input type="text" name="password" value="${user.password}"		placeholder="password"></li>
							<li><input type="text" name="email" value="${user.email}"	 placeholder="email">
							</li>
							<li>
								<button type="submit">Submit</button>
							</li>
						</ul>
					</form>
				</div>
			</div>
		</div>




	</div>

</body>
</html>