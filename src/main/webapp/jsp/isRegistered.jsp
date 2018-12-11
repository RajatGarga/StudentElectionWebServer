<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../partials/meta.jsp" %>	
<title>Registered</title>
<%@ include file="../partials/header.jsp" %>
<link type=text/css rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
</head>

<body>
<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); // Http 1.1
		response.setHeader("Pragma","no-cache"); // HTTP 1.0
		response.setHeader("Expires","0"); // Proxies
		
		String domain = (String)session.getAttribute("domain");
		String userName = (String) session.getAttribute("username"); 
		String familyName = (String) session.getAttribute("familyname");
		String email = (String) session.getAttribute("email");
		
		if(userName == null){
			response.sendRedirect("login.jsp");
		}else{
			userName = userName.toLowerCase();
			familyName = familyName.toLowerCase();				
		}
		//domain != "lnmiit.ac.in" &&
			
%>

	<div class="" style="margin:50px auto;align-content:center;padding:20px;height:90%;width:50%;">
		<div class="card text-white bg-dark mb-3" style="width:90%;height:300px;border-radius:20px;padding:10px;">
		  <div class="card-header">Message</div>
		  <div class="card-body">
		    <h3 class="card-title">Hi <% out.println(userName);%>,</h3>
		    <p class="card-text"></p>
		    <h4>You have already Registered.</h4>
		    <br><br>
		  </div>
		     <div class="card-footer text-muted">
			    <a href="../candidateProfile" class="btn btn-primary btn-lg" style="border-radius:30px;width:200px;text-decoration:none;color:white;">Profile</a>
  			</div>
		</div>
	</div>
	
<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<%@ include file="../partials/footer.jsp" %>		
</body>
</html>