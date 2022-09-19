<%@page import="com.mf.data.Box"%>
<%@page import="com.mf.web.BoxContext"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Box = box = BoxContext.get();
	String list = (String) box.get("list");
	String exeWriteResult = (String) box.get("exeWriteResult");
%>
<html>
<head>
<body>
<pre>

list.jsp

list : <%=list%>

exeWriteResult : <%=exeWriteResult%>

</pre>
</body>
</head>
</html>
