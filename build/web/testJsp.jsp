<%-- 
    Document   : testJsp
    Created on : 26 juil. 2018, 10:48:17
    Author     : Franck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            
        String var = (String) request.getAttribute("var");
        String name = (String) request.getAttribute("name");
        String mdp = (String) request.getAttribute("mdp");
        
        out.println(var);
        out.println(name);
        out.print(mdp);
        
        %>
        <br>
        <p>${name}</p>
        <p>${mdp}</p>
        <br>
        <br>
        <%= new java.util.Date() %>
    </body>
</html>
