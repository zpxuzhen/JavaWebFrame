<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>

<s:bean name="org.apache.struts2.util.Counter" var="counter">
   <s:param name="first" value="20"/>
   <s:param name="last" value="25" />
</s:bean>
<ul>
   <s:iterator value="#counter">
      <li><s:property /></li>
   </s:iterator>
</ul>
	
</body>
</html>