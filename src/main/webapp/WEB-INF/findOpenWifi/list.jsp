<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/03/26
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
     <jsp:include page="fragment/bodyHeader.jsp">
         <jsp:param name="titleName" value='<%=URLEncoder.encode("와이파이 정보 구하기", "UTF-8")%>'/>
     </jsp:include>
    <form action="/wifi/openApi" method="post">
        <p>
            <label for="lat"> LAT: </label>
            <input type="text" name="lat" id="lat" value="">
            <label for="lnt"> ,LNT: </label>
            <input type="text" name="lnt" id="lnt" value="">
            <button type="button" onclick="getMyLocation()">내 위치 가져오기</button>
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
        <tr>
            <td>0.1344</td>
            <td>WIFI12033</td>
            <td>마포구</td>
            <td>망원지구안내센터</td>
            <td>도로명주소입니다</td>
            <td>사무실 입니다.</td>
            <td>3</td>
            <td>커뮤니티-행성</td>
            <td>서울시</td>
            <td>공공아이파아</td>
            <td>임대망</td>
            <td>3030</td>
            <td>실내</td>
            <td></td>
            <td>304.2222</td>
            <td>232.3333</td>
            <td>2022-03-24 10:33:33.3</td>
        </tr>
        <tr>
            <td colspan="17" style="text-align: center">위치 정보를 입력한 후에 조회해 주세요.</td>
        </tr>
        </tbody>
    </table>

<script>
    function getMyLocation() {

    }
</script>

</body>
</html>
