<html>
<head>
    <link rel="stylesheet" href="css/main.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
 
</head>
<body>
    
    <script>
        function addBody() {
            let elements = document.querySelectorAll(".editButton")
            for (let i = 0; i < elements.length; i++) {
                elements[i].style.display = "block";
            }
        }

        function removeBody() {
            document.getElementById('wachtwoord').readOnly = true;
            document.getElementById('wachtwoord').value = null;

            let elements = document.querySelectorAll(".editButton")
            for (let i = 0; i < elements.length; i++) {
                elements[i].style.display = "none";
            }
        }
    </script>

    
    <div class="container">
        <a class="terugButton"><p class="terug">Ga terug</p></a>
        <h1 class="titel">Profiel</h1>
        <img id="pfp" class="profielFoto" src="https://png.pngtree.com/png-clipart/20210310/original/pngtree-default-male-avatar-png-image_5939655.jpg" alt="Profiel foto">
        <div class="aangepasteDif">
            <div class="gegevens">
                <input class="inputText" type="text" id="naam" name="naam" placeholder="Naam" tabindex="-1" readonly="readonly">
            </div>
            <div class="gegevens">
                <input class="inputText" type="text" name="studentenNummer" placeholder="Studentennummer" tabindex="-1" readonly="readonly">
            </div>
            <div class="gegevens">
                <input class="inputText" type="text" name="schoolMail" placeholder="Schoolmail" tabindex="-1" readonly="readonly">
            </div>
            <div class="gegevens">
                <input class="inputText" type="password" id="wachtwoord" name="wachtwoord" placeholder="Wachtwoord" tabindex="-1" readonly="readonly">
                <button onclick="document.getElementById('wachtwoord').readOnly = false; document.getElementById('wachtwoord').focus(); addBody();" id="pencilButton"><span>&#9999;</span>
                </button>
            </div>
        </div>
        <button class="editButton" id="opslaanButton">Opslaan</button>
        <button onclick="const delayRemove = setTimeout(removeBody, 100);"class="editButton" id="annuleerButton">Annuleer</button>
        
    </div>

</body>
</html>





