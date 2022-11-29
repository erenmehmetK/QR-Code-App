<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel="stylesheet" href="content/css/main.css">
	<script src="content/Javascript/profilePage.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    
    <div class="container">
		<s:form class="terug" action="QRScanner" method="POST">
		    <input class="back" type="submit" value="<"/>
		</s:form>
        <h1 class="titel">Profiel</h1>
        <img id="pfp" class="profielFoto" src="https://png.pngtree.com/png-clipart/20210310/original/pngtree-default-male-avatar-png-image_5939655.jpg" alt="Profiel foto">
        <div class="aangepasteDif">
	        <table class="table_groote">
	        <s:form method="post" action="ProfielPagina">
	          <tr> 
	              <td><s:textfield class="inputText" type="text" id="naam" name="naam" placeholder="Naam" tabindex="-1" readonly="true"/></td>
	              <td></td>
	          </tr>
	          <tr>
	              <td><s:textfield class="inputText" type="number" name="studentenNummer" placeholder="Studentennummer" tabindex="-1" readonly="true"/></td>
	              <td></td>
	          </tr>
	          <tr>
	              <td><s:textfield class="inputText" type="email" name="schoolMail" placeholder="Schoolmail" tabindex="-1" readonly="true"/></td>
	              <td></td>
	          </tr>
	          <tr>
	              <td>
	                  <s:textfield class="inputText" type="password" id="wachtwoord" name="wachtwoord" placeholder="Wachtwoord" tabindex="-1" readonly="true" required="true"/>
	                  </td><td>
	              </td>
	              <td>
	                  <button type="button" id="pencilButton">
	                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
	                          <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
	                    </svg>
	                </button>    
	              </td>
	          </tr>
	          <tr>
	            <td>
	                <s:textfield class="inputText" type="password" id="NieuwWachtwoord1" name="wachtwoord" placeholder="Nieuw wachtwoord" tabindex="-1" readonly="true" required="true"/>
	                </td><td>
	          	</td> 
	          <tr>
	          <tr>
				<td>
	                <s:textfield class="inputText" type="password" id="NieuwWachtwoord2" name="wachtwoord" placeholder="Nieuw wachtwoord" tabindex="-1" readonly="true" required="true"/>
	                </td><td>
	          	</td> 
	          </tr>
	          <tr>
	          	<td>
	          		<s:submit class="editButton" id="opslaanButton" value="Opslaan"></s:submit>
	        		<button type="button" class="editButton" id="annuleerButton">Annuleer</button>
	          	</td>
	          </tr> 
	          </s:form>
	          </table>    
	    </div>
    </div>
	<br>
	<br>
	<br>
</body>
</html>