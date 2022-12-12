<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<script src="content/Javascript/profilePage.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/FAQ.css">
</head>
<body>

     <s:form class="terugbutton" action="Home" method="POST">
		    <input class="terug" type="submit" value="<"/>
		</s:form>
    </a>

    <center>
        <h3 class="titel"> FAQ </h3>

        <table style="width: 90%;">

            <tr>
                <td>
                    <div class="divfaq">
                        <table class="divfaq">

                            <tr>
                                <th class="thfaq">
                                    <button type="button" class="collapseButtonFAQ btn btn-primary" data-bs-toggle="collapse" data-bs-target="#demo">Wat moet ik doen als ik niet kan inloggen? </button>
                                </th>
                            </tr>

                            <tr>  
                                <td>
                                    <div id="demo" class="collapse">
                                            <button type="button" class="collapseButtonFAQ btn btn-primary" data-bs-toggle="collapse" data-bs-target="#demo">Als u niet kunt inloggen ga dan naar uw coach en vraag om hulp. </button>  
                                      </div>
                                </td>
                            </tr>

                        </table>
                    </div>
                </td>
            </tr>

            <tr>
                <td>
                    <div class="divfaq">
                        <table class="divfaq">

                            <tr>
                                <th class="thfaq">
                                    <button type="button" class="collapseButtonFAQ btn btn-primary" data-bs-toggle="collapse" data-bs-target="#demo1"> Hoe check ik in? </button>
                                </th>
                            </tr>

                            <tr>  
                                <td>
                                    <div id="demo1" class="collapse">
                                      <button type="button" class="collapseButtonFAQ btn btn-primary" data-bs-toggle="collapse" data-bs-target="#demo1"> Er staat een scanner in het lokaal waar u aanwezig moet zijn, hier moet u uw qr-code tegenaan houden. </button>  
                                      </div>
                                </td>
                            </tr>

                        </table>
                    </div>
                </td>
            </tr>
            
        </table> 
    </center>
    
</body> 
</html>