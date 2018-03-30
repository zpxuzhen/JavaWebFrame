<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hello World</title>
<s:head />
</head>
<body>
   <s:form action="hello.action">
   <s:radio label="Gender" name="gender" list="{'male','female'}" />
   <s:checkboxlist label="Hobbies" name="hobbies"
   list="{'sports','tv','shopping'}" />
   </s:form>
</body>
</html>