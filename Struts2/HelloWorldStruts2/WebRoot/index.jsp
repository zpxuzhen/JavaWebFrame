<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <h1>Hello World From Struts2</h1>
   <form action="hello">
      <label for="name">Please enter your name</label><br/>
      <input type="text" name="name"/>
      <input type="submit" value="Say Hello"/>
   </form>
   <form action="upload" method="post" enctype="multipart/form-data">
      <label for="myFile">Upload your file</label>
      <input type="file" name="myFile" />
      <input type="submit" value="Upload"/>
   </form>
   <s:form action="empinfo" method="post">
      <s:textfield name="name" label="Name" size="20" />
      <s:textfield name="age" label="Age" size="20" />
      <s:submit name="submit" label="Submit" align="center" />
   </s:form>
    <s:form action="system" method="post">
      <s:submit value="System Info"/>
   </s:form>  
   SystemDetails需要xwork-conversion.properties文件或者SystemDetails-converstion.properties
   <h2>Struts2 控制标签</h2>
   <form action="myLabel1">
      <label for="name">Please pick a name</label><br/>
      <select name="name">
         <option name="Mike">Mike</option>
         <option name="Jason">Jason</option>
         <option name="Mark">Mark</option>
      </select>
      <input type="submit" value="If Label"/>
   </form>
   <form action="employee1">
      <input type="submit" value="Iterator Label"/>
   </form>
   <form action="employee2">
      <input type="submit" value="Merge Label"/>
   </form>
   <form action="employee3">
      <input type="submit" value="Append Label"/>
   </form>
   <form action="hello1">
      <input type="submit" value="Generator Label"/>
   </form>
  <h2>Struts2 数据标签</h2>
   <form action="employee4">
      <input type="submit" value="Action1 Label"/>
          可以在jsp页面,调用某个action,同时显示action对应结果页面
   </form>
   <form action="employee5">
      <input type="submit" value="Action2 Label"/>
          可以在jsp页面,调用某个action,但不显示action对应结果页面
   </form>
   <form action="employee6">
      <input type="submit" value="Include Label"/>
          可以在jsp页面,调用除了action资源之外的任何结果页面,并且可以传参数
   </form>
   <form action="employee7">
      <input type="submit" value="Bean Label"/>
   </form>
   <form action="hello3">
      <input type="submit" value="Date Label"/>
   </form>
   <form action="hello4">
      <input type="submit" value="Property,Push,Set Label"/>
   </form>
   <form action="hello5">
      <input type="submit" value="Text Label"/>
   </form>
   <form action="hello6">
      <input type="submit" value="Url Label"/>
           动态超链接
   </form>
  <h2>Struts2 表单标签</h2>
   <form action="ui1">
      <input type="submit" value="UI 1"/>
   </form>
   <form action="ui2">
      <input type="submit" value="UI 2"/>
   </form>
   <form action="ui3">
      <input type="submit" value="UI 3"/>
   </form>
   <h2>Struts2 Ajax标签</h2>
   <form action="ajax">
      <input type="submit" value="Ajax"/>
   </form>
</body>
</html>