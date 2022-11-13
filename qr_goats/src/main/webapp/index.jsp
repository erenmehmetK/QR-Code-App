<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
    	<script src="Javascript/printscreen.js"></script>
    </head>
    <body>
        <h1>Dit is HelloAction.jsp</h1>
        <s:form action="ProfielPagina" method="POST">
            <input type="submit" value="ProfielPagina"/>
        </s:form>
    </body>
</html>