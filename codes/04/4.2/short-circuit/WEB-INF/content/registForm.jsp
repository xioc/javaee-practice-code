<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2018, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
<title>����������ע����Ϣ</title>
	<s:head/>

</head>


<body>
<h2>����������ע����Ϣ</h2>
<s:form action="regist">
	<s:textfield name="name" label="�û���"/>
	<s:textfield name="pass" label="����"/>
	<s:textfield name="age" label="����"/>
	<s:textfield name="birth" label="����"/>
	<s:submit value="ע��"/>
</s:form>

</body>

</html>