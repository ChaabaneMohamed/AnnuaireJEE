<!DOCTYPE html>

<%@ include file="/WEB-INF/jsp/include.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<%@ include file="/WEB-INF/jsp/head-bootstrap.jsp"%>
</head>

<body>

    <div class="container">
        <h1>Edit Person</h1>

        <form:form method="POST" modelAttribute="person">

            <form:errors path="*" cssClass="alert alert-danger" element="div" />

            <div class="form-group">
                <label for="firstName">First Name:</label>
                <form:input class="form-control" path="firstName" />
                <form:errors path="firstName" cssClass="alert alert-warning"
                    element="div" />
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <form:textarea class="form-control" path="lastName" />
                <form:errors path="lastName" cssClass="alert alert-warning"
                    element="div" />
            </div>
            
            <div class="form-group">
                <button type="submit" class="btn btn-info">Submit</button>
            </div>
        </form:form>
    </div>

</body>
</html>