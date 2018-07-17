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
				<h3>User Ekleme  </h3>
				<c:if test="${Sonuc != null}">
				  <p>Welcome, ${Sonuc}</p>
				</c:if>
				<div class="box-content">
					<form action=User method="post" class="form">
						<ul>
							<input type="hidden" name="islem" value="ekle">
							<li><input type="text" name="username"
								placeholder="username"></li>
							<li><input type="text" name="password"
								placeholder="password"></li>
							<li><input type="text" name="email" placeholder="title">
							</li>
							<li>
								<button type="submit">Submit</button>
							</li>
						</ul>
					</form>
				</div>
			</div>
		</div>

		<div class="box-container container-50">
			<div class="box" id="div-2">
				<h3>Üyeler</h3>
				<div class="box-content">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">İD</th>
								<th scope="col">Username</th>
								<th scope="col">Password</th>
								<th scope="col">Email</th>
							</tr>
						</thead>

						<tbody>
							<!--  user verilerinin  jstl  ile alınıp tablo halinde gösterildiği yer
							<sql:setDataSource var="AllUser" driver="com.mysql.jdbc.Driver"
								url="jdbc:mysql://localhost/servletdb?&useLegacyDatetimeCode=false&serverTimezone=Turkey&useSSL=false"
								user="root" password="1234" />

							<sql:query dataSource="${AllUser}" var="result">
					            SELECT * from users;
					         </sql:query> -->
							<c:forEach items="${USER}" var="p">
								<tr>
									<th>${p.id}</th>
									<td>${p.username}</td>
									<td>${p.password}</td>
									<td>${p.email}</td>
									<td><a href="User?islem=duzenle&id=${p.id}">Edit</a> <a
										href="User?islem=sil&id=${p.id}">Delete</a></td>
								</tr>

							
							</c:forEach>

							<!--  user verileri burda biter -->

						</tbody>
					</table>
				</div>
			</div>
		</div>


	</div>

</body>
</html>