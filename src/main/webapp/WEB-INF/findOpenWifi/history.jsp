<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/03/26
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>History</title>
    <link href="/resources/css/table.css" rel="stylesheet" type="text/css">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="fragment/bodyHeader.jsp">
    <jsp:param name="titleName" value='<%=URLEncoder.encode("위치 히스토리 목록", "UTF-8")%>'/>
</jsp:include>
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
            <c:forEach items="${dtoList}" var="dto">
                <tr>
                    <td>${dto.id}</td>
                    <td>${dto.getXValue()}</td>
                    <td>${dto.getYValue()}</td>
                    <td>${dto.searchDateTime}</td>
                    <td class="button-table">
                        <button id=${dto.id} type="button" onclick="deleteHistory(${dto.id})">삭제</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

    <script>
        function deleteHistory(id) {
            $.ajax({
                url: "/wifi/history",
                type: "POST",
                data: {id : id},
                async: false,
                success: function () {
                    alert("데이터가 삭제되었습니다.");
                    location.reload();
                },
                error: function () {
                    alert("데이터 삭제 실패했습니다.");
                }
            });
        }
    </script>
</body>

</html>
