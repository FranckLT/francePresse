<%-- 
    Document   : home
    Created on : 26 juil. 2018, 15:15:12
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page import="java.util.List"%>
<%@page import="fr.france_presse.java_bean.Dispatch"%>
<%@page import="fr.france_presse.java_bean.Dispatch"%>
<%@page import="fr.france_presse.java_bean.Reporter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
    </head>
    <body>
        <% Reporter reporter = (Reporter) session.getAttribute("user");%>
             
        <%@include file="/Jsp/topMenu.jsp" %>
               
        <div class="container">
             
        <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
            
            <h1 class="display-4">Welcome  <%=reporter.getName()%></h1>
                    
            <p class="lead">Liste des dernières depêches.</p>
                    
        </div>
            
        <c:forEach items="${list}" var="dispatch" varStatus="status">
            
            <h2><a href="/FrancePresse/dispatch?id=${dispatch.idDispatch}">${dispatch.title}</a></h2>
            
            <c:if test="${not empty dispatch.reporterName}">
            <p>Written by : ${dispatch.reporterName}</p>
              </c:if>
        </c:forEach>
            
    </div>
             
       
    </body>
</html>
