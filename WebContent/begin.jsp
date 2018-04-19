<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>测试</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript">
function reloadurl(){ window.location.href="mid.jsp"; }  
window.setTimeout("reloadurl();",3000);
</script>
</head>
<body>  
<br><br><br>
       <table border="1" align="center" cellspacing="0" cellpadding="15">
       		<c:forEach items="${sessionScope.list}" var="emp" varStatus="status">
       			<tr>
       				<td width="25%">${emp.name }</td>
       				<td width="25%">${emp.age }</td>
       				<td width="25%">${emp.sex }</td>
       				<td width="25%">${emp.fav }</td>
       			</tr>
       		</c:forEach>
       </table>
  
</body>   
</html> 