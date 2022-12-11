<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
  <title>Application</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>

<body class="grey lighten-5">

  <nav class="blue lighten-4" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="${pageContext.request.contextPath}/main" class="brand-logo blue-text">App</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="${pageContext.request.contextPath}/login" class="blue-text">Login</a></li>
      </ul>

      <ul id="nav-mobile" class="sidenav">
        <li><a href="${pageContext.request.contextPath}/login" class="blue-text">Login</a></li>
      </ul>
      <a href="" data-target="nav-mobile" class="sidenav-trigger blue-text"><i class="material-icons">menu</i></a>
    </div>
  </nav>

  <br> <br>
  <br> <br>

  <div class="container">
    <div class="row">
      <form class="col s12" action="register" method="post">
        <div class="row">
          <h5 class="center-align">Create new account</h5>
          <p class="h6 center-align" style="color:lightseagreen;">${output}</p>
          <div class="input-field col s3 offset-s3">
            <input id="Name" type="text" class="validate" name="userName">
            <label for="Name">Name</label>
          </div>
          <div class="input-field col s3">
            <input id="Surname" type="text" class="validate" name="userSurname">
            <label for="Surname">Surname</label>
          </div>
          <div class="input-field col s6 offset-s3">
            <input id="Login" type="text" class="validate" name="login">
            <label for="Login">Login</label>
          </div>
          <div class="input-field col s3 offset-s3">
            <input id="Password" type="password" class="validate" name="password">
            <label for="Name">Password</label>
          </div>
          <div class="input-field col s3">
            <input id="Confirm password" type="password" class="validate" name="confirmPassword">
            <label for="Confirm password">Confirm password</label>
          </div>
          <div class="input-field col s6 offset-s3">
            <p class="h6 center-align" style="color:red;">${error}</p>
            <button class="btn waves-effect light-blue" type="submit" name="action">Create
              <i class="material-icons right">account_box</i>
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>

  <br> <br>
  <br> <br>
  <br> <br>
  <br> <br>

  <footer class="page-footer blue lighten-4">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="blue-text">Application description</h5>
          <p class="blue-text text-lighten-2">Some text about application.</p>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
        <p class="blue-text text-lighten-2">© 2022 Copyright Text</p>
      </div>
    </div>
  </footer>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

</body>

</html>