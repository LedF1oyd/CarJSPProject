<%--
  Created by IntelliJ IDEA.
  User: jiuhyeong
  Date: 2022/11/19
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>



        <html>
<head>
    <title>Title</title>

</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.example.*,java.io.File"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%
  String filename="";
  int sizeLimit = 15*1024*1024;

  String realPath = request.getServletContext().getRealPath("upload");

  File dir=new File(realPath);
  if(!dir.exists()) {dir.mkdirs();System.out.println("디렉토리 생성");}
  else{
    System.out.println("디렉토리 존재");
  }
  MultipartRequest multipartRequest =null;
  multipartRequest = new MultipartRequest(request, realPath,sizeLimit, "utf-8",new DefaultFileRenamePolicy());
  filename=multipartRequest.getFilesystemName("photo");
  System.out.println(realPath);
  System.out.println(filename);
%>
파일명: <%=filename%><br/>
<img src="${pageContext.request.contextPath}/upload/<%=filename%>">

</body>
</html>
