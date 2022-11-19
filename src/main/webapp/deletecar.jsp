<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.example.dao.CarDAO, com.example.bean.CarVO, com.example.util.FileUpload"%>
<%
    String carid = request.getParameter("id");
    if (carid != ""){
        int id = Integer.parseInt(carid);
        CarDAO carDAO = new CarDAO();
        CarVO u = new CarVO();
        u.setCarid(id);
        String filename = carDAO.getPhotoFilename(id);
        if(filename !=null){
            FileUpload.deleteFile(request, filename);
        }
        carDAO.deleteCar(u);
    }
    response.sendRedirect("cars.jsp");
%>