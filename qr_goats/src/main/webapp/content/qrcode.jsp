<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="content/css/qrcode.css">
<link rel="stylesheet" href="content/css/main.css">
<title>QR Code</title>
</head>
<body>
	<div class="section">
		<h1>De QR Code</h1>
		<p>Gebruik deze QR Code om in te checken.</p>
		<a href="../faq.jsp">problemen met inchecken?</a>
		<div class="qrcode">${qrCode.currentQR}</div>
		<div class="ingechecked">status: <b style="color: green">ingecheckt</b></div><br><br>
		<div class="time" id="time"></div>
		
		<script>
			const time = document.getElementById("time");
			function updateTime() {
				let date = new Date();
				time.innerHTML = (date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
				setTimeout(updateTime, 1000)
			}
			updateTime();
		</script>
	</div>
</body>
</html>