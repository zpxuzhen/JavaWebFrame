<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Employees</title>
</head>
<body>
   
   <s:action name="hello2" executeResult="false">
      Output from Hello:  <br />
   </s:action>
   <s:iterator value="#attr.names">
	   <s:property /><br />
   </s:iterator>

</body>
</html>