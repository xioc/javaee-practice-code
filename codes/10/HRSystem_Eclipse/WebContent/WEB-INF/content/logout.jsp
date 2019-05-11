<%
  session.invalidate();
%>
<%@ page contentType="text/html; charset=GBK" language="java" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>系统登出</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
  <p class="bg-info">
  您已经成功地登出系统，欢迎下次光临</p>
</div>
<%@include file="footer.jsp"%>
</body>
</html>


