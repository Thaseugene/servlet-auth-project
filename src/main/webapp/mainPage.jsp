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
                <h3>Welcome,</h3>
                <h3 class="text-container" style="color:lightseagreen;">${output}</h3>
                <div class="row">
                    <div class="col d-flex justify-content-center">
                        <p class="h6">Anonymous? Login first</p>
                    </div>
                    <div class="col d-flex justify-content-center">
                        <p class="h6">or Register</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col d-flex justify-content-center">
                        <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-primary" role="button">Login</a>
                    </div>
                    <div class="col d-flex justify-content-center">
                        <a href="${pageContext.request.contextPath}/registration.jsp" class="btn btn-primary" role="button">Register</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
