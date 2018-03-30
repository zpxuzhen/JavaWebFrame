<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Employees</title>
</head>
<body>
   <b>Employees and Contractors Merged together</b>
   <br />
   <s:append  var="allemployees">
      <s:param value="employees" />
      <s:param value="contractors" />
   </s:append >
   <s:iterator value="allemployees">
      <s:property value="name"/>,
      <s:property value="department"/><br/>
   </s:iterator>
</body>
</html>