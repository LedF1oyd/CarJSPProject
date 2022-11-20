<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.example.dao.CarDAO"%>
<%@page import="com.example.bean.CarVO"%>
<%@page import="com.example.util.FileUpload"%>





<%
    request.setCharacterEncoding("utf-8");
    CarDAO carDAO = new CarDAO();

    FileUpload upload =new FileUpload();
    CarVO u = upload.uploadPhoto(request);
    System.out.println("editcar.jsp에 들어온 id: "+u.getCarid());


    int i=carDAO.updateCar(u);
    String msg = "데이터 수정 성공 !";
    if(i == 0) msg = "[에러] 데이터 수정 실패 ";
    System.out.println(msg);

%>

<script>
    alert('<%=msg%>');
    location.href='cars.jsp';
</script>