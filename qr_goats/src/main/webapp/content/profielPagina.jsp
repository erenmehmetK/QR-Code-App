<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel="stylesheet" href="content/css/main.css">
    <link rel="stylesheet" href="content/css/profielPagina.css">
	<script src="content/Javascript/profilePage.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
    
    <div class="container">
		<s:form class="terugbutton" action="Home" method="POST">
		    <input class="terug" type="submit" value="<"/>
		</s:form>
        <h1 class="titel">Profiel</h1>
        <img id="pfp" class="profielFoto" src="https://png.pngtree.com/png-clipart/20210310/original/pngtree-default-male-avatar-png-image_5939655.jpg" alt="Profiel foto">
        <div class="aangepasteDif">
	        <table class="table_groote">
	        
	          <tr> 
	              <td><label class="profielLabel">Naam</label><input class="inputText" type="text" id="naam" name="naam" placeholder="${Student.naam} ${Student.tussenvoegsel} ${Student.achternaam}" tabindex="-1" readonly="true"/></td>
	              <td></td>
	          </tr>
	          <tr>
	              <td><label class="profielLabel">Studenten-Nummer</label><input class="inputText" type="number" name="studentenNummer" placeholder="${Student.studentenNR}" tabindex="-1" readonly="true"/></td>
	              <td></td>
	          </tr>
	          <tr>
	              <td><label class="profielLabel">E-mail</label><input class="inputText" type="email" name="schoolMail" placeholder="${Account.email}" tabindex="-1" readonly="true"/></td>
	              <td></td>
	          </tr>
	          
	          <s:form action="WijzigWachtwoordCheck" method="post" enctype="multipart/form-data">
		          <tr>
		              <td>
		              	  <label class="wachtwoordWijzigLabel">Oud Wachtwoord</label>
		                  <s:textfield class="inputText" type="password" id="wachtwoord" name="oudww" placeholder="Oud wachtwoord" tabindex="-1" required="true"/>
		                  </td>
		                  <td>
		              </td>
		          </tr>
		          <tr>
		          	<td>
		          		<button type="button" id="pencilButton">Wijzig Wachtwoord
						</button>
						</td><td>
		          	</td>
				 </tr>
		          <tr>
		            <td>
		            	<label class="wachtwoordWijzigLabel">Nieuw Wachtwoord</label>
		                <s:textfield class="inputText" type="password" id="NieuwWachtwoord1" name="nieuwww1" placeholder="Nieuw wachtwoord" tabindex="-1" required="true"/>
		                </td><td>
		          	</td> 
		          <tr>
		          <tr>
					<td>
						<label class="wachtwoordWijzigLabel">Herhaal Nieuw Wachtwoord</label>
		                <s:textfield class="inputText" type="password" id="NieuwWachtwoord2" name="nieuwww2verify" placeholder="Herhaal nieuw wachtwoord" tabindex="-1" required="true"/>
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