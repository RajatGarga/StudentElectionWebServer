<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../partials/meta.jsp" %>  
<title>Home page</title>

<link type=text/css rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="./css/candidateForm.css">
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
	<h1>${username}</h1>
	<a href="profile.jsp">profile</a>
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>
	
	<div class="container">
		<form autocomplete="off" class="form-style-Bitter">
			<h2>Candidate Form<span></span></h2>
			<div class="section"><span>1</span>Name</div>
				<div class="inner-wrap">
	        		<label for="fname">First Name <input id="fname" type="text" name="firstName" required/></label>
	        		<label for="mname">Middle Name <input id="mname" type="text" name="middleName" /></label>
	        		<label for="lname">Last Name <input id="lname" type="text" name="lastName" /></label>
    			</div>
    			<div class="section"><span>2</span>Email &amp; Phone Number</div>
				<div class="inner-wrap">
	        		<label for="email">Email<input id="email" type="text" name="email" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="25" pattern=".+@lnmiit.ac.in" required title="eg:- 16ucs001@lnmiit.ac.in "/></label>
	        		<label for="Pnumber">Phone Number <span>+91</span><input id="Pnumber" type="number" name="PhoneNumber" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" pattern="\d*" maxlength="10" required title="10 chars required"/></label>
    			</div>
    			<div class="section"><span>3</span>Academic Info</div>
    			<div class="inner-wrap">
    				<label>Batch</label>
    				<select style="border-radius:20px;" required>
    					<option value="" disabled="disabled" selected="selected">Please select your batch</option>
    					<option value="Y18">Y18</option>
					  	<option value="Y17">Y17</option>
					  	<option value="Y16">Y16</option>
					  	<option value="Y15">Y15</option>
    				</select>
    			</div>
    			<div class="inner-wrap">
    				<label>CGPA</label><input id="cgpa" type="number" step="any" max="10" min="0" required>
    			</div>
	    	
	    	<div class="innder-wrap">
	    		<input id="submit" type="submit" value="Submit">		
	    	</div>		
		</form>
	</div>
<%@ include file="../..//partials/footer.jsp" %>	
<script type="text/javascript">
$(document).ready(function(){
	
	$('#cgpa').on('change',function(){
		if(parseInt($(this).val()) > parseInt($(this).attr('max')))
		{ console.log('worked');
			 $(this).val('');
		}
	});
	
    $('#dropdownList').on('change',function(){
        //var optionValue = $(this).val();
        //var optionText = $('#dropdownList option[value="'+optionValue+'"]').text();
        var optionText = $("#dropdownList option:selected").text();
        alert("Selected Option Text: "+optionText);
    });
});

</script>	
</body>
</html>