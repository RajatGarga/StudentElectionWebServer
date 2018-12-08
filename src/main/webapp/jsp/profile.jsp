<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../partials/meta.jsp" %>	
<title>Profile page</title>
<%@ include file="../../partials/header.jsp" %>	

</head>
<body>
<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); // Http 1.1
		response.setHeader("Pragma","no-cache"); // HTTP 1.0
		response.setHeader("Expires","0"); // Proxies

		if(session.getAttribute("username")==null){
			response.sendRedirect("login.jsp");
		}
		
%>
	<h4>Profile page</h4>
	
<%@ include file="../../partials/footer.jsp" %>	
</body>
</html>