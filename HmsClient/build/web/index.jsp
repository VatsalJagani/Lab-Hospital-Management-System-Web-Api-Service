<%-- 
    Document   : index
    Created on : 4 Mar, 2017, 4:08:50 PM
    Author     : Vatsal Jagani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.CaptchasDotNet" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Patient Details</title>
    <link href="style/css/bootstrap.min.css" rel="stylesheet">
    <link href="style/css/heroic-features.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Cancer-Care</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">
        <!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1>Check Patient ID</h1>
            <p>Patient Verification</p>
        </header>

        <hr>
        <%
// Construct the captchas object (Default Values)
CaptchasDotNet captchas = new CaptchasDotNet(
  request.getSession(true),     // Ensure session
  "demo",                       // client
  "secret"                      // secret
  );
%>
  <form method="get" action="<%=response.encodeUrl("CheckPatientID")%>">
    <table class="table table-bordered">
      <tr>
          <td class="text-right">
          Patient ID :</td><td><input name="patientID" size="60" />
        </td>
      </tr>
      <tr>
          <td class="text-right" rowspan="2">
          Enter the CAPTCHA :
        </td>
        <td>
          <input name="captcha" size="16" />
        </td>
      </tr>
      <tr>
        <td>
          <%= captchas.image() %><br>
          <a href="<%= captchas.audioUrl() %>">Phonetic spelling (mp3)</a>
        </td>
      </tr>
      <tr>
        <td>
        </td>
        <td>
          <input type="submit" value="Submit" />
        </td>
      </tr>
    </table>
          <h4 class="text-danger">${requestScope.msg}</h4>
  </form>
<hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Cancer-Care 2017</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <script src="${initParam['Root']}/style/js/jquery.js"></script>
    <script src="${initParam['Root']}/style/js/bootstrap.min.js"></script>
</body>

</html>