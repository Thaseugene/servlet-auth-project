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
      <a id="logo-container" href="${pageContext.request.contextPath}/profile" class="brand-logo blue-text">App</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="${pageContext.request.contextPath}/logout" class="blue-text">Logout</a></li>
      </ul>

      <ul id="nav-mobile" class="sidenav">
        <li><a href="${pageContext.request.contextPath}/logout" class="blue-text">Logout</a></li>
      </ul>
      <a href="" data-target="nav-mobile" class="sidenav-trigger blue-text"><i class="material-icons">menu</i></a>
    </div>
  </nav>

  <br> <br>
  <br> <br>

  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <h2 class="header center blue-text">User information</h2>
      <div class="row center">
        <h5 class="header col s12 light">Login: ${user.getLogin()}</h5>
        <h5 class="header col s12 light">Name: ${user.getUserName()}</h5>
        <h5 class="header col s12 light">Surname: ${user.getUserSurname()}</h5>
        <h5 class="header col s12 light">Registration date: ${registrationDate}</h5>
      </div>
      <br> <br>
	  <br> <br>
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