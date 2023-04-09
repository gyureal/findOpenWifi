<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/03/26
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List</title>
    <meta charset="UTF-8">
    <style>
        table {
            width: 100%;
        }

        thead th {
            text-align: center;
            background-color: #04B431;
            color: #FFFFFF;
            padding : 0.5em 0.5em
        }

        tbody tr td {
            padding : 0.3em 0.5em
        }

        tbody tr:nth-child(2n) {
            background-color: #F2F2F2;
        }
        tbody tr:nth-child(2n+1) {
            background-color: #FFFFFF;
        }

        .button-table {
            text-align: center;
        }

    </style>
</head>
<body>
    <jsp:include page="util/loading/loading.jsp" />
     <jsp:include page="fragment/bodyHeader.jsp">
         <jsp:param name="titleName" value='<%=URLEncoder.encode("와이파이 정보 구하기", "UTF-8")%>'/>
     </jsp:include>
    <form action="/wifi/list" method="post" onsubmit="return validateInput()">
        <p>
            <label for="lat"> LAT: </label>
            <input type="number" name="lat" step="any" id="lat" value="">
            <label for="lnt"> ,LNT: </label>
            <input type="number" name="lnt" step="any" id="lnt" value="">

            <button id="getPositionBtn"  type="button">내 위치 가져오기</button>
            <button type="submit">근처 WIFI 정보 보기</button>
        </p>
    </form>
    <table>
        <thead>
        <tr>
            <th>거리<br>(Km)</th>
            <th>관리번호</th>
            <th>자치구</th>
            <th>와이파이명</th>
            <th>도로명주소</th>
            <th>상세주소</th>
            <th>설치위치<br>(층)</th>
            <th>설치유형</th>
            <th>설치기관</th>
            <th>서비스구분</th>
            <th>망종류</th>
            <th>설치년도</th>
            <th>실내외구분</th>
            <th>WIFI접속환경</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>작업일자</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${empty dtoList}">
            <tr>
                <td colspan="17" style="text-align: center">위치 정보를 입력한 후에 조회해 주세요.</td>
            </tr>
        </c:if>
        <c:forEach items="${dtoList}" var="dto">
            <tr>
                <td>${dto.distance}</td>
                <td>${dto.mgrNo}</td>
                <td>${dto.wrdofc}</td>
                <td>${dto.mainNm}</td>
                <td>${dto.adres1}</td>
                <td>${dto.adres2}</td>
                <td>${dto.instlFloor}</td>
                <td>${dto.instlTy}</td>
                <td>${dto.instlMby}</td>
                <td>${dto.svcSe}</td>
                <td>${dto.cmcwr}</td>
                <td>${dto.cnstcYear}</td>
                <td>${dto.inoutDoor}</td>
                <td>${dto.remars3}</td>
                <td>${dto.lat}</td>
                <td>${dto.lnt}</td>
                <td>${dto.workDttm}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<script>
    function getMyLocation() {
        function success(position) {
            const latitude  = position.coords.latitude;
            const longitude = position.coords.longitude;

            let lat = document.querySelector('#lat');
            let lnt = document.querySelector('#lnt');
            lat.value = latitude;
            lnt.value = longitude;

            hideLoading();
            alert("위치 정보를 성공적으로 가져왔습니다.");
        }

        function error() {
            alert('현재 위치를 가져오는데 실패했습니다.');
        }

        if(!navigator.geolocation) {
            alert('현재 위치를 가져올 수 없는 브라우저 입니다.');
        } else {
            showLoading();
            navigator.geolocation.getCurrentPosition(success, error);
        }
    }

    document.querySelector('#getPositionBtn').addEventListener('click', getMyLocation);

    function validateInput() {
        var lat = document.getElementById('lat').value;
        var lnt = document.getElementById('lnt').value;
        console.log(lat);
        console.log(lnt);
        if (lat == null || lnt == null || lat == '' || lnt == '') {
            alert("좌표값을 입력해 주세요");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
