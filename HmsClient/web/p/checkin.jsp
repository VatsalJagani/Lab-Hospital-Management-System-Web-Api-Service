<%-- 
    Document   : checkin
    Created on : Mar 5, 2017, 1:29:50 PM
    Author     : Vatsal Jagani
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="classes.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Patient Check-In list</title>
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
                        <a href="${initParam['Root']}/p/patient_info.jsp">Patient Info</a>
                    </li>
                    <li>
                        <a href="#">Check-In List</a>
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
            <h1>Check-In List</h1>
            <p>This all checkins for Patient Name : ${patient.name}</p>
        </header>

        <hr>
        <table class="table table-bordered table-hover table-responsive">
            <tr>
                <th>Check-In No.</th>
                <th>Room</th>
                <th>Check-In Time</th>
                <th>CheckOut Time</th>
                <th>Get Reports</th>
            </tr>
        <c:forEach items="${clist.list}" var="check">
            <tr>
                <td><fmt:formatNumber maxFractionDigits="0">${check.checkinNo}</fmt:formatNumber></td>
                <td><fmt:formatNumber maxFractionDigits="0">${check.room}</fmt:formatNumber></td>
                <td>${check.intime}</td>
                <td>${check.outtime}</td>
                <td><a href="${initParam['Root']}/GetReports?check_no=${check.checkinNo}" class="btn btn-primary">Get Reports</a></td>
            </tr>
        </c:forEach>
        </table>
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
