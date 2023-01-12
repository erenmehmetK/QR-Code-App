<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="alert alert-success alert-dismissible fade show">
        <strong>Success!</strong> Succesvol verandered.
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    </div>
    <jsp:include page="/content/profielPagina.jsp"></jsp:include>
</body>