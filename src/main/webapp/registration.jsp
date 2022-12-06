<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Servlet test app</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<div class="container form-container">
    <div class="row justify-content-center align-items-center">
        <div class="col-md-6">
            <div class="col-md-12 login-form-1">
                <h5>Create new account</h5>
                <p class="h6" style="color:lightseagreen;">${output}</p>
                <form action="auth" method="post">
                    <input type="hidden" name="actionType" value="register">
                    <div class="form-group">
                        <input type="text" class="form-control" name="login" placeholder="Enter new login" value=""/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="Password" value=""/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm password" value=""/>
                    </div>
                    <p class="h6" style="color:red;">${error}</p>
                    <div class="form-group">
                        <button class="btnSubmit" type="submit" value="register">Register</button>
                    </div>
                    <div class="form-group">
                        <a href="${pageContext.request.contextPath}/login.jsp" class="To-login">To login page</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
