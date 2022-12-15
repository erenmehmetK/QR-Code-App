<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="http://fonts.cdnfonts.com/css/centrale-sans-regular" rel="stylesheet">
    <link rel="stylesheet" href="content/css/login.css">

    <style>
        @import url('http://fonts.cdnfonts.com/css/centrale-sans-regular');
    </style>

</head>
<body>
    <container>
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
            <div class="col-md-4 col-sm-4 col-xs-12">
                <img id="logo" src="content/embed/logo.png"> </img>

                  
        
                    
       
                <center> 
                 <div class="form-group">
                    
				    <s:form class="form-container" action="logincheck" method="post">
				      <h1>Log in</h1>
				      <label> Email</label>
				      <s:textfield  name="acc.email" label="Email" type="Email" class="form-control" placeholder="Email-adres"/>
				      <small id="emailHelp" class="form-text text-muted">Dit moet je studenten e-mailadres zijn</small>
				      <br>
				      <label> Wachtwoord </label>
				      <s:textfield name="acc.wachtwoord" label="wachtwoord" type="password" class="form-control" placeholder="Wachtwoord" />
		
				      <s:submit class="btn btn-primary btn-block"/>
				    </s:form>	
				    
                </div>
                </center>
                
                
                <hr>

            </div>
            <div class="col-md-4 col-sm-4 col-xs-12"></div>

        </div>
        
    </container>

    
</body>
</html>