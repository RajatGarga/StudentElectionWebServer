<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta Http-Equiv="Cache-Control" Content="no-cache">
<meta Http-Equiv="Pragma" Content="no-cache">
<meta Http-Equiv="Expires" Content="0">

<title>Insert title here</title>

</head>
<body onload="setTimeout(signoutRedirect,5000)">
	
	<h1>Please signin with your lnmiit email id</h1>
	<h3>Redirecting to login page in 5 seconds...</h3>
<script>
function signoutRedirect() {
	  console.log("worked");
	  document.location.href = "https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/Management/nomineeLogout";		
}
</script>
</body>
</html>