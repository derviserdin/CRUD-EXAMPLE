<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%
    
    	 // Bir otorum var ise  ana sayfaya yönlendirme
    	if(session.getAttribute("user")!=null  ){
    		 response.sendRedirect(request.getContextPath() + "/AddNew?islem=ekle.jsp");
    	}
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

    <meta charset="UTF-8">
    <title>Document</title>

    <!--styles-->
    <link rel="stylesheet" href="assets/styles/main.css">

    <!--scripts-->
    <script src="assets/scripts/jquery-1.12.2.min.js"></script>
    <script src="https://cdn.ckeditor.com/4.5.7/basic/ckeditor.js"></script>
    <script src="assets/scripts/admin.js"></script>

</head>
<body>

    <!--login screen-->
    <div class="login-screen">
        
        <!--login logo
        <div class="login-logo">
            <a href="#">
                <img src="assets/images/logo.png" alt="">
            </a>
        </div> -->
        
        <form action="login" method="post">
            <ul>
                <li>
                    <label for="username">Username</label>
                    <input type="text" id="username"  name="username">
                </li>
                <li>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password">
                </li>
                <li>
                    <button type="submit">Login</button>
                    <label for="remember" class="checkbox">
                        <input type="checkbox" id="remember"> Remember me
                    </label>
                </li>
            </ul>
        </form>

        <div class="login-links">
            <a href="#" class="lost-password">
                Have you lost your mind?
            </a>
            <a href="#">
                <span class="fa fa-long-arrow-left"></span> Back to the future?
            </a>
        </div>

    </div>

</body>
</html>