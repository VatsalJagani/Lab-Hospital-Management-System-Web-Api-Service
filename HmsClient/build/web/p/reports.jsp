<%-- 
    Document   : TreatmentReports
    Created on : Mar 5, 2017, 1:30:22 PM
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

    <title>Patient Reports</title>
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
            <h1>Patient Reports</h1>
            <p>This all reports for Patient Name : ${patient.name}</p>
        </header>

        <hr>
        <h4>Treatment Reports</h4>
        <table class="table table-bordered table-hover table-responsive">
            <tr>
                <th>No.</th>
                <th>Date</th>
                <th>Medical Prescription</th>
                <th>Lab Prescription</th>
                <th>Suggestion</th>
            </tr>
        <c:forEach items="${treatments.list}" var="tr">
            <tr>
                <td><fmt:formatNumber maxFractionDigits="0">${tr.trNo}</fmt:formatNumber></td>
                <td><fmt:formatDate value="${tr.trDate}" type="date"></fmt:formatDate></td>
                <td>${tr.medicalPre}</td>
                <td>${tr.labPre}</td>
                <td>${tr.suggestion}</td>
            </tr>
        </c:forEach>
        </table>
        
        <hr>
        <h4>Laboratory Reports</h4>
        <table class="table table-bordered table-hover table-responsive">
            <tr>
                <th>No.</th>
                <th>Date</th>
                <th>Glucose</th>
                <th>Hemoglobin</th>
                <th>RDC</th>
                <th>WBC</th>
                <th>AFP</th>
                <th>PSA</th>
            </tr>
        <c:forEach items="${lab_reports.list}" var="tr">
            <tr>
                <td><fmt:formatNumber maxFractionDigits="0">${tr.laboratoryNo}</fmt:formatNumber></td>
                <td><fmt:formatDate value="${tr.labDate}" type="date"></fmt:formatDate></td>
                <td>${tr.glucose}</td>
                <td>${tr.hemoglobin}</td>
                <td>${tr.rdc}</td>
                <td>${tr.wbc}</td>
                <td>${tr.afp}</td>
                <td>${tr.psa}</td>
            </tr>
        </c:forEach>
        </table>
        
        <hr>
        <h4>Hospital Bills</h4>
        <table class="table table-bordered table-hover table-responsive">
            <tr>
                <th>No.</th>
                <th>Date</th>
                <th>Doctor Fee</th>
                <th>Room Fee</th>
                <th>Lab Fee</th>
                <th>Medical Fee</th>
                <th>Operation Charge</th>
                <th>Other</th>
            </tr>
        <c:forEach items="${bills.list}" var="tr">
            <tr>
                <td><fmt:formatNumber maxFractionDigits="0">${tr.billNo}</fmt:formatNumber></td>
                <td><fmt:formatDate value="${tr.billDate}" type="date"></fmt:formatDate></td>
                <td><fmt:formatNumber maxFractionDigits="2">${tr.doctorFee}</fmt:formatNumber></td>
                <td><fmt:formatNumber maxFractionDigits="2">${tr.roomFee}</fmt:formatNumber></td>
                <td><fmt:formatNumber maxFractionDigits="2">${tr.labFee}</fmt:formatNumber></td>
                <td><fmt:formatNumber maxFractionDigits="2">${tr.medicalFee}</fmt:formatNumber></td>
                <td><fmt:formatNumber maxFractionDigits="2">${tr.opFee}</fmt:formatNumber></td>
                <td><fmt:formatNumber maxFractionDigits="2">${tr.otherFee}</fmt:formatNumber></td>
                
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