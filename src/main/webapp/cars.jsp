<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.example.dao.CarDAO, com.example.bean.CarVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>등록된 중고차</title>
    <style>
        #list {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #list td, #list th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align:center;
        }
        #list tr:nth-child(even){background-color: #f2f2f2;}
        #list tr:hover {background-color: #ddd;}
        #list th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }
    </style>
    <script>
        function delete_ok(id){
            var a = confirm(id+" 정말로 삭제하겠습니까?");
            if(a) location.href='deletecar.jsp?id=' + id;
        }
    </script>
</head>
<body>
<h1>자동차</h1>
<%
    CarDAO CarDAO = new CarDAO();
    List<CarVO> list = CarDAO.getCarList();
    request.setAttribute("list",list);
    System.out.println();
%>
<table id="list" width="90%">
    <tr>
        <th>No.</th>
        <th>브랜드</th>
        <th>차종</th>
        <th>차명</th>
        <th>색상</th>
        <th>사진</th>
        <th>제조일</th>
        <th>누적거리</th>
        <th>제조사 보증</th>
        <th>옵션</th>
        <th>세부사항</th>
        <th>가격</th>
        <th>등록일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.getCarid()}</td>
            <td>${u.getBrand()}</td>
            <td>${u.getCarType()}</td>
            <td>${u.getCarName()}</td>
            <td>${u.getColor()}</td>
            <td >
                <c:if test="${u.getPhoto() ne ''}"><br/>
                    <img src="${pageContext.request.contextPath}/upload/${u.getPhoto()}"
                         style="width:100px; height:100px;"
                    >
                </c:if>
            </td>
            <td>${u.getManufacturedDay()}</td>
            <td>${u.getMileage()}</td>
            <td>${u.getWarranty()}</td>
            <td>${u.getOptions()}</td>
            <td>${u.getDescription()}</td>
            <td>${u.getPrice()}</td>
            <td>${u.getRegDate()}</td>
            <td><a href="editcarform.jsp?id=${u.getCarid()}">수정</a></td>
            <td><a href="javascript:delete_ok('${u.getCarid()}')">삭제</a></td>
        </tr>
    </c:forEach>
</table>
<br/><a href="addcarform.jsp">새로 등록</a>
</body>
</html>