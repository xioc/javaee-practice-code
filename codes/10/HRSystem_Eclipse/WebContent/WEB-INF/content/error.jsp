<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>出错提示</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
<div class="panel panel-danger text-center">
  <div class="panel-heading">
    <h4>系统处理过程中发生了一个错误，信息如下：</h4>
  </div>
  <p>&nbsp;</p>
  <s:property value="exception.message"/>
  <p>&nbsp;</p>
  <div class="panel-footer">
请您先核对输入，如果再次出现该错误，<br>
请登录<a href="http://www.crazyit.org">http://www.crazyit.org</a>寻求答案，谢谢。
   </div>
</div>
</div>
<%@include file="footer.jsp"%> 
</body>
</html>

