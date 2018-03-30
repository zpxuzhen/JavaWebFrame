<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>System Details</title>
</head>
<body>
   <p>The environment name property can be accessed in three ways:</p>

   (Method 1) Environment Name: 
   <s:property value="environment.name"/><br/>

   (Method 2) Environment Name: 
   <s:push value="environment">
      <s:property value="name"/><br/>
   </s:push>

   (Method 3) Environment Name:
   <s:set var="myenv" value="environment.name" />
   <s:property value="myenv"/>
</body>
</html>