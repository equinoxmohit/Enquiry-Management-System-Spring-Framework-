<%-- 
    Document   : edit
    Created on : Sep 20, 2016, 8:57:48 PM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>Edit</h1>
        <form method="post" action="${pageContext.request.contextPath}/edit/${employee.id}/save">
            <label>First Name</label>
            <input type="text" name="firstName" class="form-control" required="required" value="${employee.firstName}">
            <label>Last Name</label>
            <input type="text" name="lastName" class="form-control" required="required" value="${employee.lastName}">
            <label>Email Id</label>
            <input type="email" name="emailId" class="form-control" required="required" value="${employee.emailId}">
            <label>Contact Number</label>
            <input type="number" name="contactNumber" class="form-control" required="required" value="${employee.contactNumber}">
            
           <button type="submit" class="btn btn-success">Submit</button>
            <button type="reset" class="btn btn-danger">Reset</button>
        </form>
    </body>
</html>
