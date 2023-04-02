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
    <form>
        <p>
            <label for="lat"> LAT: </label>
            <input type="text" name="lat" id="lat" value="">
            <label for="lnt"> ,LNT: </label>
            <input type="text" name="lnt" id="lnt" value="">
            <button onclick="">내 위치 가져오기</button>
            <button onclick="">근처 WIFI 정보 보기</button>
        </p>
    </form>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>조회일자</th>
            <th>비고</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>1234.1123</td>
            <td>124.145</td>
            <td>2023-04-23T02:34:35</td>
            <td class="button-table">
                <button type="button" onclick="deleteHistory()">삭제</button>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>1234.1123</td>
            <td>124.145</td>
            <td>2023-04-23T02:34:35</td>
            <td class="button-table">
                <button type="button" onclick="deleteHistory()">삭제</button>
            </td>
        </tr>
        </tbody>
    </table>

</body>
</html>
