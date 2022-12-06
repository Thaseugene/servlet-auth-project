<%@ page contentType="text/html" language="java" isELIgnored="false" %>
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
                <h5>Please, enter login and password</h5>
                <form action="auth" method="post">
                    <input type="hidden" name="actionType" value="login">
                    <div class="form-group">
                        <input type="text" class="form-control" name="login" placeholder="Login name" value=""/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="Password" value=""/>
                    </div>
                    <p class="h6" style="color:red;">${error}</p>
                    <div class="form-group">
                        <button class="btnSubmit" type="submit" value="Login">Sign in</button>
                    </div>
                    <div class="form-group">
                        <a href="${pageContext.request.contextPath}/registration.jsp" class="Not-a-Member">Not a member ?</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>

</body>

</html>
