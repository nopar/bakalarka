<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Home page</title>
    </head>
    <body>
        <h1>Home page</h1>
        
        <p>
            <a href="${pageContext.request.contextPath}/team/add.html">Add new - team</a><br/>
            <a href="${pageContext.request.contextPath}/team/list.html">Team - ZOZNAM</a><br/>
        </p>
        
        <p>
            <a href="${pageContext.request.contextPath}/skupiny/add.html">Add new - Krvnu Skupinu</a><br/>
            <a href="${pageContext.request.contextPath}/skupiny/list.html">Krvne skupiny - ZOZNAM</a><br/>
        </p>
        
        <p>
            <a href="${pageContext.request.contextPath}/stat/add.html">Add new - stat</a><br/>
            <a href="${pageContext.request.contextPath}/stat/list.html">Stat - ZOZNAM</a><br/>
        </p>

        ${message}<br/>
    </body>
</html>