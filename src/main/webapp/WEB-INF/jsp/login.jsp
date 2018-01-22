<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cashman 3001</title>
 
<spring:url value="/resources/core/css/login.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
 
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Cashman 3001</a>
	</div>
  </div>
</nav>
 

	<spring:url value="/login" var="userActionUrl" /> 
<div class="container">
 
  <div class="wrapper">
    <form:form class="form-signin" method="post" modelAttribute="userForm" action="${userActionUrl}">       
      <h2 class="form-signin-heading">Login</h2>
      <c:if test="${error ne null}">
      <div class="alert alert-danger">
		  ${error}
	  </div>
	  </c:if>
      <form:input path="username" type="text" class="form-control" id="username" placeholder="User Name" />
      <br/>
      <form:password path="password" class="form-control" id="password" placeholder="Password" />      
      <br/>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
   </form:form>
  </div>
 
 
  <hr>
  
</div>
 
<%-- <spring:url value="/resources/core/css/cashman.css" var="coreJs" /> --%>
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>