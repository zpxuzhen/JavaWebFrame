<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>
<h2>Current Date</h2>

<h3>Day/Month/Year Format</h3>
<s:date name="currentDate" format="dd/MM/yyyy" />

<h3>Month/Day/Year Format</h3>
<s:date name="currentDate" format="MM/dd/yyyy" />
	
</body>
</html>