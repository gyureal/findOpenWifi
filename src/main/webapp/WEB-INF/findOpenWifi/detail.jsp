<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/04/10
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Detail</title>
    <meta charset="UTF-8">
    <link href="/resources/css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
    <jsp:include page="fragment/bodyHeader.jsp">
        <jsp:param name="titleName" value='<%=URLEncoder.encode("와이파이 정보", "UTF-8")%>'/>
    </jsp:include>
    <form id="bookmark-form" action="/bookmark/add" method="post">
        <select name="groupName">
            <option value="">북마크 그룹 이름 선택</option>
            <c:forEach items="${groupList}" var="group">
                <option value="${group.id}">${group.groupName}</option>
            </c:forEach>
        </select>
        <button type="submit">즐겨찾기 추가하기</button>
    </form>
    <table>
        <tr>
            <th>거리(Km)</th>
            <td><fmt:formatNumber type="number" value="${dto.distance}" maxFractionDigits="4" /></td>
        </tr>
        <tr>
            <th>관리번호</th>
            <td>${dto.mgrNo}</td>
        </tr>
        <tr>
            <th>자치구</th>
            <td>${dto.wrdofc}</td>
        </tr>
        <tr>
            <th>와이파이명</th>
            <td>${dto.mainNm}</td>
        </tr>
        <tr>
            <th>도로명주소</th>
            <td>${dto.adres1}</td>
        </tr>
        <tr>
            <th>상세주소</th>
            <td>${dto.adres2}</td>
        </tr>
        <tr>
            <th>설치위치(층)</th>
            <td>${dto.instlFloor}</td>
        </tr>
        <tr>
            <th>설치유형</th>
            <td>${dto.instlTy}</td>
        </tr>
        <tr>
            <th>설치기관</th>
            <td>${dto.instlMby}</td>
        </tr>
        <tr>
            <th>서비스구분</th>
            <td>${dto.svcSe}</td>
        </tr>
        <tr>
            <th>망종류</th>
            <td>${dto.cmcwr}</td>
        </tr>
        <tr>
            <th>설치년도</th>
            <td>${dto.cnstcYear}</td>
        </tr>
        <tr>
            <th>실내외구분</th>
            <td>${dto.inoutDoor}</td>
        </tr>
        <tr>
            <th>WIFI접속환경</th>
            <td>${dto.remars3}</td>
        </tr>
        <tr>
            <th>X좌표</th>
            <td>${dto.lat}</td>
        </tr>
        <tr>
            <th>Y좌표</th>
            <td>${dto.lnt}</td>
        </tr>
        <tr>
            <th>작업일자</th>
            <td>${dto.workDttm}</td>
        </tr>
    </table>


</body>
</html>
