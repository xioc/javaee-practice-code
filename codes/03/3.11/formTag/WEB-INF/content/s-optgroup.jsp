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
	<title>ʹ��s:optgroup��������ѡ����ѡ����</title>
	<s:head/>
</head>
<body>
<h3>ʹ��s:optgroup��������ѡ����ѡ����</h3>
<s:form>
<!-- ֱ��ʹ��MapΪ�б�������ѡ�� -->
<s:select label="ѡ����ϲ����ͼ��" name="book" size="7"
	list="#{'���Java����':'���'
		,'������Java EE��ҵӦ��ʵս':'���'
		,'���iOS����':'���'}"
	listKey="value"
	listValue="key">
	<!-- ʹ��Map����������ѡ����ѡ���� -->
	<s:optgroup label="Rod Johnson"
		list="#{'Expert One-on-One J2EE Design and Development':'Johnson'}"
		listKey="value"
		listValue="key"/>
	<s:optgroup label="David Flanagan"
		list="#{'JavaScript: The Definitive Guide':'David'}"
		listKey="value"
		listValue="key"/>
</s:select>
</s:form>
</body>
</html>