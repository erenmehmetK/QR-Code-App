// Zorgt dat de onclick functies later inladen om errors te voorkomen
	window.onload = function(){
		// Je wachtwoord veranderen
		document.getElementById("pencilButton").onclick = function() {
			document.getElementById('wachtwoord').readOnly = false;
			document.getElementById('wachtwoord').focus(); addBody();
			document.getElementById('NieuwWachtwoord1').readOnly = false;
			document.getElementById('NieuwWachtwoord2').readOnly = false;
			addBody();
		};
		// Wachtwoord veranderen annuleren
		document.getElementById("annuleerButton").onclick = function() {
			const delayRemove = setTimeout(removeBody, 100);
			document.getElementById('NieuwWachtwoord1').value = '';
			document.getElementById('NieuwWachtwoord2').value = '';
		};
	}

	// Voegt de inputs toe om wachtwoord te kunnen wijzigen
    function addBody() {
        let elements = document.querySelectorAll(".editButton")
        for (let i = 0; i < elements.length; i++) {
            elements[i].style.display = "block";
        }
        document.getElementById('NieuwWachtwoord1').style.display = "block";
        document.getElementById('NieuwWachtwoord2').style.display = "block";
        
        document.getElementById('wachtwoord').placeholder = "Oud wachtwoord";
        
        let inputs = document.querySelectorAll(".inputText")
        for (let i = 0; i < inputs.length; i++) {
        	inputs[i].style.display = "none";
        }
        document.getElementById("wachtwoord").style.display = "block";
        
        document.getElementById("NieuwWachtwoord1").style.display = "block";
        document.getElementById("NieuwWachtwoord2").style.display = "block";
        document.getElementById("pencilButton").style.display = "none";
    }

	// Verwijderd de inputs toe om wachtwoord te kunnen wijzigen
    function removeBody() {
        document.getElementById('wachtwoord').readOnly = true;
        document.getElementById('wachtwoord').value = null;

        let elements = document.querySelectorAll(".editButton")
        for (let i = 0; i < elements.length; i++) {
            elements[i].style.display = "none";
        }
        document.getElementById('NieuwWachtwoord1').style.display = "none";
        document.getElementById('NieuwWachtwoord2').style.display = "none";
        
        document.getElementById('wachtwoord').placeholder = "Wachtwoord";
        
        let inputs = document.querySelectorAll(".inputText")
        for (let i = 0; i < inputs.length; i++) {
        	inputs[i].style.display = "block";
        }
        document.getElementById("NieuwWachtwoord1").style.display = "none";
        document.getElementById("NieuwWachtwoord2").style.display = "none";
        document.getElementById("pencilButton").style.display = "block";
    }
    
	// Leegt de inputs
    function clearNieuwWachtwoord() {
    	var element = document.getElementById('NieuwWachtwoord1').element.reset();
    	var element = document.getElementById('NieuwWachtwoord2').element.reset();
    }