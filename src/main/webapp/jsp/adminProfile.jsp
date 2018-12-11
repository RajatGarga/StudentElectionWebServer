<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../partials/meta.jsp" %>	
<title>Profile</title>
<%@ include file="../partials/header.jsp" %>
<link type="text/css" rel="stylesheet" href="../css/navbar_doom.css">
<link type="text/css" rel="stylesheet" href="../css/candidateForm.css">
<style>
.menu_items a:hover .icon:after {
  border-color: #2A88AD;
}
.menu_items a:active .icon {
  color: #2A88AD;
}
.menu_toggle{
		  background-color: #2A88AD;
}
.registrationbtn:hover {
	background-color: #2A6881;
}
</style>
<script type="text/javascript" src="../js/HandleSignOut.js"></script>  
</head>
<body>
<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); // Http 1.1
		response.setHeader("Pragma","no-cache"); // HTTP 1.0
		response.setHeader("Expires","0"); // Proxies
		
		String adminUsername = (String) session.getAttribute("adminUsername");
		String adminEmail = (String) session.getAttribute("adminEmail");
		
		if(adminUsername == null){
			response.sendRedirect("login.jsp");
		}
		//domain != "lnmiit.ac.in" &&
			
%>
	
<div class="page" style="position:absolute;top:0;left:0;right:0;">
  <span class="menu_toggle">
    <i class="menu_open fa fa-bars fa-lg"></i>
    <i class="menu_close fa fa-times fa-lg"></i>
  </span>
  <ul class="menu_items">
    <li><a href="../adminProfile"><i class="icon fa fa-user fa-2x"></i> Profile</a></li>
    <li><a href="../candidateList"><i class="icon fa fa-list-ul fa-2x"></i> List</a></li>
    <li><a href="../adminLogout"><i class="icon fa fa-sign-out fa-2x"></i> Logout</a></li>
  </ul>
  <main class="content">
    <div class="content_inner">
    	
		<div class="form-style-Bitter">
			<h2>Profile<span>lnmiit.ac.in</span></h2>
			<div class="section"><span style="position:relative;padding:10px;"><i class="fa fa-list-ul" aria-hidden="true"></i></span>&nbsp; Details</div>
				<div class="inner-wrap">
					<div class="container-fluid">
		      	<h3>${adminDetails.firstName} ${adminDetails.familyName}</h3>
		      	<br>
		      	<table class="table table-striped">
				  <tbody>
				  <tr>
				      <th scope="row">Username</th>
				      <td>${adminDetails.userName}</td>
				    </tr>
				    <tr>
				      <th scope="row">Name</th>
				      <td>${adminDetails.firstName} ${adminDetails.familyName}</td>
				    </tr>
				    <tr>
				      <th scope="row">Email Id</th>
				      <td>${adminDetails.email}</td>
				    </tr>
				    
				  </tbody>
				</table>
				<br><br>
				 <div class="row">
					<div class="col-md-6 col-sm-6 col-xs-6">
						<form action="" method="post"> 
							<input type="submit" class="registrationbtn" style="border-radius:20px;outline:0px;" value="Start Registration">
						</form>
					</div>	<!-- background-color:#2A88AD  -->
					<div class="col-md-6 col-sm-6 col-xs-6">
						<form action="" method="post">
							<input type="submit"  class="registrationbtn" style="border-radius:20px;outline:0px;" value="Stop Registration">
						</form>
					</div>	
				</div>
				<br><br>
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-6">
						<form action="" method="post"> 
							<input type="submit" class="registrationbtn" style="border-radius:20px;outline:0px;" value="Start Voting">
						</form>
					</div>	<!-- background-color:#2A88AD  -->
					<div class="col-md-6 col-sm-6 col-xs-6">
						<form action="" method="post">
							<input type="submit"  class="registrationbtn" style="border-radius:20px;outline:0px;" value="Stop Voting">
						</form>
					</div>	
				</div>
				<br><br>
		      </div>
				</div>  	
	    	<form action="../adminProfile/edit" method="get">	    	
	    	<div class="inner-wrap">
	    		<input id="submit" class="" style="border-radius:20px;outline:0px;" type="submit" value="Edit Details">		
	    	</div>		
	    	</form>
		</div>
	
    </div>
  </main>
</div>

<%@ include file="../partials/footer.jsp" %>	
<script type="text/javascript" src="../js/navbar_doom.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	  
   
});
</script>
</body>
</html>














	