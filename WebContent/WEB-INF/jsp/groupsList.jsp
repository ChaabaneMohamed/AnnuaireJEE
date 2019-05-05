<!DOCTYPE html>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<c:url var="edit" value="/actions/person/edit" />

<html>
<head>
<title>Hello :: Spring Application</title>
<%@ include file="/WEB-INF/jsp/head-bootstrap.jsp"%>
</head>
<body>
	<div class="container">
    <h1>Groups</h1>
    <ul class="table table-hover">
    <c:forEach items="${groups}" var="gr">
        <li>
	        <a href="${edit}?id=${gr.id}">
	            <c:out value="${gr.name}" />
	        </a>
	        
	       	<ul>
	        <c:forEach items="${gr.persons.values()}" var="pr">
			    <li>
			    	<p><c:out value="${pr.firstName}" /> <c:out value="${pr.lastName}" /></p>
			    	<ul>   			      
				        <li>web: <c:out value="${pr.web}" /></li>
				        <li>password: <c:out value="${pr.password}" /></li>
			        </ul>
			    </li>
			</c:forEach>
			</ul>
			
        </li>
    </c:forEach>
    </ul>
    <p>
    	<a class="btn btn-info" href="${edit}">Create new product</a>
    </p>
    </div>
</body>
</html>