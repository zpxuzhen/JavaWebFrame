<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>

<h2>Example of Generator Tag</h2>
<h3>The colours of rainbow:</h3>

<s:generator val="%{'Violet,Indigo,Blue,
         Green,Yellow,Orange,Red '}" count="7" 
         separator=",">
   <s:iterator>
      <s:property /><br/>
   </s:iterator>
</s:generator>	
	
</body>
</html>