<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cashman 3001</title>
 
<spring:url value="/resources/core/css/cashman.css" var="coreCss" />
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
 
<div class="jumbotron">
  <div class="container">
	<h1>${title}</h1>
	<p>
		<c:choose>
			<c:when test="${not empty userName}">
				Hello ${userName} !
			</c:when>
			<c:otherwise>
				Welcome Welcome!
			</c:otherwise>
		</c:choose>
		
    </p>    
	</div>
</div>
 
<div class="container">
  <h2>Available denominations ...</h2> <br/>
  <div class="row">
	<div class="col-md-4">
		<h4>Twenty Currency Notes: ${denominations.twennty}</h4>
	</div>	
	<div class="col-md-4">
		<h4>Forty Currency Notes: ${denominations.forty}</h4>
	</div>
	<div class="col-md-4">
		<h4>Fifty Currency Notes: ${denominations.fifty}</h4>
	</div>
  </div>
  
  <div class="row">
	<div class="col-md-4">
		<h4>Sixty Currency Notes: ${denominations.sixty}</h4>
	</div>	
	<div class="col-md-4">
		<h4>Seventy Currency Notes: ${denominations.seventy}</h4>
	</div>
	<div class="col-md-4">
		<h4>Eighty Currency Notes: ${denominations.eighty}</h4>
	</div>
  </div>
  
  <div class="row">
	<div class="col-md-4">
		<h4>Hundred Currency Notes: ${denominations.hundred}</h4>
	</div>	
	<div class="col-md-4">
		<h4>Hudred Ten Currency Notes: ${denominations.hundredTen}</h4>
	</div>
	<div class="col-md-4">
		<h4>Hundred Fifty Currency Notes: ${denominations.hundredFifty}</h4>
	</div>
  </div>
  
  <div class="row">
	<div class="col-md-4">
		<h4>Two Hundred Currency Notes: ${denominations.twoHundred}</h4>
	</div>	
	<div class="col-md-4">
		<h4>Total available amount: ${total}</h4>
	</div>
		
	</div>
	
	 <c:choose>
	 <c:when test="${total gt 0}">
	 
	  <c:if test="${result ne null}">
	 <div class="row">
	  	<div class="alert alert-success">
	    <strong>Success!</strong> ${result}
	  </div>
	 </div>
	 </c:if>
	 <div class="row">
	  	<h2>Enter amount to withdraw ...</h2> <br/>
	 	 <spring:url value="/withdraw" var="withdrawActionUrl" /> 
	 	 <form:form class="form-signin" method="get" modelAttribute="withdrawForm" action="${withdrawActionUrl}">       
	      	
	        <form:input path="amount" class="form-control" id="amount" placeholder="Enter Amount" />
	        <br/>
	      <button class="btn btn-lg btn-primary" type="submit">Withdraw</button>   
	   </form:form>
	 </div>
	 </c:when>
	 <c:otherwise>
	 	<div class="row">
	 		<h1>You do not have enough money to withdraw.</h1>
	 	</div>
	 </c:otherwise>
 </c:choose>
	
  </div>

  <hr>
  
 
<%-- <spring:url value="/resources/core/css/cashman.css" var="coreJs" /> --%>
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>