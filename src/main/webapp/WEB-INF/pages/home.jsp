<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>NTS - Bakalarka</title>
    </head>
    <body>
        <h1>Home page</h1>
        
       
        <p>
            <a href="${pageContext.request.contextPath}/stat/add.html">Add new - stat</a><br/>
            <a href="${pageContext.request.contextPath}/stat/list.html">Stat - ZOZNAM</a><br/>
        </p>

        ${message}<br/>
    </body>
</html>