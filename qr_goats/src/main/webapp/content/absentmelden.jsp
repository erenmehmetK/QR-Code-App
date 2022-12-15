<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="http://fonts.cdnfonts.com/css/centrale-sans-regular" rel="stylesheet">
    <link rel="stylesheet" href="css/telaatmelden.css">
    <style>
        @import url('http://fonts.cdnfonts.com/css/centrale-sans-regular');
        </style>
    
    <script>
    function confirmRequest() {
    	confirm("Ben je zeker dat je een melding wilt versturen?");
    }
    </script>
 
  
    <title>Document</title>
</head>
<body>
    <s:form class="terugbutton" action="Home" method="POST">
		    <input class="terug" type="submit" value="<"/>
		</s:form>
<img src="embed/zandklok.png" alt="gino.png (zandklok)" >
<container>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                    <div class="card text-white mb-3">
                        <div id="melden">
                        <h1> Absent melden</h1>
                        <div class="card-body">
                            <form method="POST">
                                <!-- Vorm van melding selecteren -->
                                <div class="form-group">
                                    <label for="exampleFormControlSelect2">Kies uw melding</label>
                                    <select class="form-control" id="exampleFormControlSelect2">
                                        <option>Kies een optie...</option>
                                        <option>Ziek melden</option>
                                        <option>Laat melden</option>
                                    </select>
                                    
                        
                        </div>
                        </form>
                        </div>
                    </div>
                    </div>

                       <!-- Te laat melden -->
                       <div id="telaatmelden">
                        <div class="card text-white bg-white mb-3">
                            <h1> Laat melden</h1>
                            <div class="card-body">
                                <form action="laatMelding" method="POST">
                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1">Reden</label>
                                        <select class="form-control" id="exampleFormControlSelect1" name="reden">
                                            <!-- Te laat reden selecteren -->
                                            <option>Verslapen</option>
                                            <option>OV vertraging</option>
                                            <option>Overige</option>
                                        </select>
                                        
                                        <div id="opmerking">
                                        <div class="form-group">
                                            <label for="exampleFormControlTextarea1">Opmerking</label>
                                            <textarea class="form-control" id="exampleFormControlTextarea1" name="opmerking" rows="1"></textarea>
          
                                    
                                </div>
        
                                </div>
                                <button type="submit" onclick="confirmRequest()" class="btn btn-primary">Melden</button>
                            </form>
                                </div>
                            </div>
                            </div>
                        </div>


                    <!-- Ziek melden -->
<div id="ziekmelden">
    <div class="card text-white bg-white mb-3" >
        <h1> Ziek melden</h1>
        <div class="card-body">
            <form action="ziekMelding" method="POST">
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Meld hier jezelf ziek.</label>
                
            </div>
            </div>
            
            <button type="submit" onclick="confirmRequest()" class="btn btn-primary">Melden</button>
            </form>
            </div>
        </div>
        
    </div>
    </div>
                    <script>
                        // event listener toevoegen aan de knop
                        document.getElementById("exampleFormControlSelect2").onchange = voegMelding;
                        
                        function voegMelding() {
                            // de waarde van de selectie ophalen
                            var selectie = document.getElementById("exampleFormControlSelect2").value;
                            if(selectie === "Ziek melden"){
                                // maak ziek melden div zichtbaar
                                document.getElementById("telaatmelden").style.display = "none";
                                document.getElementById("ziekmelden").style.display = "block";

                                
                            }else if(selectie === "Kies een optie...") {
                                // maak melding menus ontzichtbaar
                                document.getElementById("telaatmelden").style.display = "none";
                                document.getElementById("ziekmelden").style.display = "none";

                                
                            } 
                            else {
                // maak te laat melden zichtbaar 
                                document.getElementById("telaatmelden").style.display = "block";
                                document.getElementById("ziekmelden").style.display = "none";

                            }
                        }
                        
                        
                            </script> 
                    <hr>
                 
                        <script>
                            // event listener toevoegen aan de knop
                            document.getElementById("exampleFormControlSelect1").onchange = voegCommentaar;
                            
                            function voegCommentaar() {
                                // de waarde van de selectie ophalen
                                var selectie = document.getElementById("exampleFormControlSelect1").value;
                                // als de selectie gelijk is aan "Overige" dan maak het commentaar veld zichtbaar
                                if(selectie === "Overige"){
                                    // zorgt voor focus op het commentaar veld
                                    setTimeout(function(){ document.getElementById("exampleFormControlTextarea1").focus(); }, 100);
                                    document.getElementById("opmerking").style.display = "block";
                                    
                                }else{
                                    // maak het commentaar veld onzichtbaar
                                    document.getElementById("opmerking").style.display = "none";
                                }
                            }
                            
                            
                                </script> 

</container>
</body>
</html>