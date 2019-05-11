<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2018, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=GBK">
   <title>处理申请</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>
<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">
    当前用户：<s:property value="#session.user"/></h3>
  </div>
  <div class="panel-body">
    <table class="table table-striped">
      <thead>
        <tr>
          <th>员工名</th>
          <th>缺勤类型</th>
          <th>申请类型</th>
          <th>理由</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="apps">  
        <tr>
          <td><s:property value="emp"/></td>
          <td><s:property value="unAttend"/></td>
          <td><s:property value="toAttend"/></td>
          <td><s:property value="reason"/></td>
          <td>
            <a href='check.action?result=pass&appid=<s:property value="id"/>'>
			  通过</a>&nbsp;&nbsp;
            <a href='check.action?result=deny&appid=<s:property value="id"/>'>
			  拒绝</a>
          </td>
        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>