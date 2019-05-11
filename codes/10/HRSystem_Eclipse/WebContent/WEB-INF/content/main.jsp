<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Java EE简单工作流系统</title>
</head>
<body>
<%@include file="header.jsp"%> 
<div class="container">
<div class="jumbotron">
	<h1>简单工作流系统</h1>
	<p>这仅仅是一个Java EE的框架程序。应用模拟一个简单的工作流系统。系统包含两个角色，普通员工的功能包括员工出勤打卡，员工的人事异动申请，员工查看工资单。经理的功能包括管理部门员工，签核申请，每月工资自动结算等。应用模拟了简单的工作流，使用的轻量级Java EE架构。技术包括：Struts 2.5、Spring 5.0、Hibernate 5.2、Quartz 2.2，整个应用使用Spring提供的DAO支持操作数据库，同时利用Spring的声明式事务。程序中的权限检查使用Spring的AOP框架支持，也利用了Spring的任务调度抽象，Hibernate为底层的数据库访问提供支持,作为O/R Mapping框架使用。本程序的源代码随程序一起发布，版权属于李刚（<a href="http://www.crazyit.org">http://www.crazyit.org</a>），
	  任何个人可用来参考学习Java EE架构，规范，但请勿在本程序的基础上修改，用做任何商业用途。<br>
	  本人保留依法追究相关责任的权利。转载和学习请保留此信息。</p>
	<p><a class="btn btn-primary btn-lg" href="login" role="button">登录系统</a></p>
</div>
</div>
<%@include file="footer.jsp"%> 
</body>
</html>
