<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
  <%

	response.sendRedirect(request.getContextPath() + "/testServlet");

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <base href="<%=basePath%>">  
        <title>�ļ��ϴ�</title>  
        <meta http-equiv="pragma" content="no-cache">  
        <meta http-equiv="cache-control" content="no-cache">  
        <meta http-equiv="expires" content="0">  
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
        <meta http-equiv="description" content="This is my page">  
    </head>  
  
    <!-- <body>  
        <form action="fileupload" method="post" enctype="multipart/form-data" name="form1">  
            <input type="file" name="file">  
             <input type="file" name="file">
              <input type="file" name="file">
            <input type="submit" name="Submit" value="upload">  
        </form>  
  
    </body>  -->
</html> 