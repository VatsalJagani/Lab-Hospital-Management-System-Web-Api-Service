<%-- 
    Document   : patient_info
    Created on : Mar 21, 2017, 9:28:21 PM
    Author     : VATSAL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Patient Info</title>
    <link href="${initParam['Root']}/style/css/bootstrap.min.css" rel="stylesheet">
    <link href="${initParam['Root']}/style/css/heroic-features.css" rel="stylesheet">
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
                <a class="navbar-brand" href="${initParam['Root']}/index.jsp">Cancer-Care</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Patient Info</a>
                    </li>
                    <li>
                        <a href="${initParam['Root']}/GetCheckins">Check-In List</a>
                    </li>
                    
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
            <h1>Patient Info</h1>
            <p>Patient Name : ${patient.name}</p>
        </header>

        <hr>

        <table class="table table-striped">
            <tr>
                <th>Name</th>
                <td>${patient.name}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${patient.address}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${patient.city}</td>
            </tr>
            <tr>
                <th>Birth-Date</th>
                 <td><fmt:formatDate value="${patient.birthdate}" type="date"></fmt:formatDate></td>
            </tr>
            <tr>
                <th>Gender</th>
                <td><c:if test="${patient.gender}">Male</c:if><c:if test="${!patient.gender}">Female</c:if></td>
            </tr>
            <tr>
                <th>Marital Status</th>
                <td><c:if test="${patient.maritalStatus}">Married</c:if><c:if test="${!patient.maritalStatus}">Un-married</c:if></td>
            </tr>
            <tr>
                <th>Registration Date</th>
                <td><fmt:formatDate value="${patient.regDate}" type="date"></fmt:formatDate></td>
            </tr>
        </table>
        
        <hr>
        <a href="${initParam['Root']}/GetCheckins">Get All Check-Ins</a>
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