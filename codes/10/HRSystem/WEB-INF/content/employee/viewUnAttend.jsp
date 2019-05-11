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
   <title>查看自己的非正常出勤</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="empheader.jsp"%>
<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">
    当前用户：<s:property value="#session.user"/></h3>
  </div>
  <div class="panel-body">
    <table class="table table-hover">
      <thead>
        <tr>
          <th>打卡日期</th>
          <th>异动名称</th>
          <th>打卡时间</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="unAttend">  
        <tr>
          <td><s:property value="dutyDay"/></td>
          <td><s:property value="unType"/></td>
          <td><s:property value="time"/></td>
          <td><a href='appChange?attid=<s:property value="id"/>'>申请改变</a></td>
        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>