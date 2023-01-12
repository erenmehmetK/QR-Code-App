<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Privacyreglement </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="content/css/privacy.css">
</head>
<body>
    <a>
         <s:form class="terugbutton" action="Home" method="POST">
		    <input class="terug" type="submit" value="<"/>
		</s:form>
    </a>

    <center>
    
        <h3 class="titel"> Privacyregelement | Scalda</h3>
        <br><br>
         
         <form action="http://www.scalda.nl/privacy-statement">
            <input type="submit" value="Klik om te openen" />
        </form>
      
    </center>
    
</body> 
</html>