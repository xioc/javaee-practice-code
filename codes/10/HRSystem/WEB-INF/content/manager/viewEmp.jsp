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
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=GBK">
   <title>查看本部门全部员工</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>
<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">
     查看部门的全部员工</h3>
  </div>
  <div class="panel-body">
    <table class="table table-hover table-striped">
      <thead>
        <tr>
          <th>员工名</th>
          <th>密码</th>
          <th>工资</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="emps">  
        <tr>
          <td><s:property value="empName"/></td>
          <td><s:property value="empPass"/></td>
          <td><s:property value="amount"/></td>
        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>