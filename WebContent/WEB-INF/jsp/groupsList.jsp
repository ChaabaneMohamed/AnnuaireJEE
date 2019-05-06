<!DOCTYPE html>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<c:url var="edit" value="/actions/person/edit" />

<html>
<head>
<title>Liste des personnes</title>
<%@ include file="/WEB-INF/jsp/head-bootstrap.jsp"%>
</head>
<body>
	<div class="container">
    <h1>Groupes</h1>
    <table class="table table-hover">
    <c:forEach items="${groups}" var="gr">
		<p><c:out value="${gr.name}" /></p>
    	<table class="table table-hover">
    			<tr>
		        	<td>Prenom:<td/>
				    <td>Nom:<td/>
				    <td>Site Web:<td/>
				    <td>Mot de passe:<td/>
				</tr> 
		        <c:forEach items="${persons}" var="pr">
		        		<c:if test="${pr.groupId == gr.id}">
			        		<tr>
			        			<td><c:out value="${pr.firstName}"/><td/>
					    		<td><c:out value="${pr.lastName}" /><td/>
					    		<td><c:out value="${pr.web}" /><td/>
					    		<td><c:out value="${pr.password}" /><td/>
					    		<td><a href="${edit}?id=${pr.id}">Edit</a><td/>
					    	</tr>
				    	</c:if>
				</c:forEach>
    	</table>
    </c:forEach>
    </table>
    <p>
    	<a class="btn btn-info" href="${edit}">Create new product</a>
    </p>
    </div>
</body>
</html>