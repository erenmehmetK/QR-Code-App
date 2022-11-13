
// disabled Printscreen
document.addEventListener('keyup', (e) => {
    if (e.key == 'PrintScreen') {
    	if (noScreenshot)
    	{
        navigator.clipboard.writeText('');
        
      }
    }
});


// geen niet kunnen opslaan

document.addEventListener('keydown', (e) => {
    if (e.ctrlKey && e.key == 'p') {
        if (noPrint)
	    	{
	        e.cancelBubble = true;
	        e.preventDefault();
	        e.stopImmediatePropagation();
	      }
    }
});