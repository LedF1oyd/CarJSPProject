<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>addcar</title>
</head>
<body>

<h1>자동차 등록</h1>
<form action="addcar.jsp" method="post" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <td>
                차량의 제조사를 선택하여 주세요.
            </td>
            <td>
                <select id = "brandSelection" name = "brand">
                    <option value="현대">현대</option>
                    <option value="기아">기아</option>
                    <option value="제네시스">제네시스</option>
                    <option value="쌍용">쌍용</option>
                    <option value="르노코리아자동차">르노코리아자동차</option>
                    <option value="한국GM">한국GM</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                차종을 골라주세요.
            </td>
            <td>
                <input type="radio" id="sedan" name="carType" value="Sedan">
                <label for="sedan">세단</label><br>
                <input type="radio" id="suv" name="carType" value="SUV">
                <label for="suv">SUV</label><br>
                <input type="radio" id="hatchBack" name="carType" value="Hatch-Back">
                <label for="hatchBack">해치백</label><br>
                <input type="radio" id="wagon" name="carType" value="Wagon">
                <label for="hatchBack">웨건</label><br>
                <input type="radio" id="coupe" name="carType" value="Coupe">
                <label for="hatchBack">쿠페</label><br>
            </td>
        </tr>
        <tr>
            <td>
                차량의 이름을 입력하여주세요.
            </td>
            <td>
                <label for="carName">차량명:  </label>
                <input type="text" id="carName" name="carName">
            </td>
        </tr>
        <tr>
            <td>
                차량의 생상을 입력하여주세요.
            </td>
            <td>
                <label for="color">색상:  </label>
                <input type="text" id="color" name="color">
            </td>
        </tr>
        <tr>
            <td>
                차량의 사진파일을 업로드하여주세요
            </td>
            <td>
                <input type='file' name='photo'>
            </td>
        </tr>
        <tr>
            <td>
                차량제조일을 입력하여주세요
            </td>
            <td>
                <label for="manufacturedDay">제조일</label>
                <input type="date" id="manufacturedDay" name="manufacturedDay" value="2000-01-01">
            </td>
        </tr>
        <tr>
            <td>
                차량의 주행거리를 입력하여주세요.
            </td>
            <td>
                <label for="mileage"></label>
                <input type="number" id="mileage" name="mileage" min="0" max="1000000">
                <label for="mileage">km  </label>
            </td>
        </tr>
        <tr>
            <td>
                제조사보증이 유효하다면 체크해주세요
            </td>
            <td>
                <input type="checkbox" id="warranty" name="warranty" value="Manufacturer Warranty Valid">
                <label for="warranty">예</label><br>
            </td>
        </tr>
        <tr>
            <td>
                차량의 옵션을 모두 체크해주세요
            </td>
            <td>
                <input type="checkbox" id="led" name="option" value="LED 헤드램프" class="checkSelect">
                <label for="led">LED 헤드램프</label><br>
                <input type="checkbox" id="HID" name="option" value="HID 헤드램프" class="checkSelect">
                <label for="HID">HID 헤드램프</label><br>
                <input type="checkbox" id="HUD" name="option" value="HUD(Head Up Display)" class="checkSelect">
                <label for="HUD">HUD(Head Up Display)</label><br>
                <input type="checkbox" id="열선시트" name="option" value="열선시트" class="checkSelect">
                <label for="열선시트">열선시트</label><br>
                <input type="checkbox" id="통풍시트" name="option" value="통풍시트" class="checkSelect">
                <label for="통풍시트">통풍시트</label><br>
                <input type="checkbox" id="navigation" name="option" value="내비게이션" class="checkSelect">
                <label for="navigation">내비게이션</label><br>
            </td>
        </tr>
        <tr>
            <td>
                기타 차량에 대한 설명과 장단점을 알려주세요.
            </td>
            <td>
                <textarea id=description name=description style="width:90%;" rows="30"></textarea><br>
            </td>
        </tr>
        <tr>
            <td>
                판매 희망 가격을 입력하여주세요.
            </td>
            <td>
                <label for="price">가격:  </label>
                <input type="number" id="price" name="price">
                <label for="price">원  </label>
            </td>
        </tr>

        <tr>
            <td><a href="cars.jsp">테이블 보기</a></td>
            <td align="right"><input type="submit" value="등록"/></td>
        </tr>
    </table>
</form>

</body>
</html>