<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
<s:url action="index" var="myurl">
	<s:param name="user">Zara</s:param>
</s:url>

<a href='<s:property value="#myurl"/>'>
<s:property value="#myurl"/></a>

</body>
</html>