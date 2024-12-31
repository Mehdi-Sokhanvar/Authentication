<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12/27/2024
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%--email ,phonenumber ,country,  password , --%>
<% String error = (String) request.getAttribute("error");%>
<% if (error != null) {%>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
    <strong><%=error%>
    </strong>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
<%}%>

<div class="container">
    <form method="post" action="signup">
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="phonenumber">Phone_number</label>
            <input type="text" name="phonenumber" class="form-control" id="phonenumber" aria-describedby="emailHelp"
                   placeholder="Enter Phone_number">
        </div>
        <div class="form-group">
            <label for="country">Country </label>
            <input type="text" name="country" class="form-control" id="country"
                   placeholder="Enter Country">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <div class="form-group form-check">
        <input type="checkbox" name="cheakpassword" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <div class="form-group form-check">
        <input type="checkbox" name="showpassword" class="form-check-input" id="showpassword">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
</div>
<div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
