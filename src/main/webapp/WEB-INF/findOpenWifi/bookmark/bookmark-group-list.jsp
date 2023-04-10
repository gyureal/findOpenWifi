<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/04/10
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>북마크 그룹 목록</title>
    <link href="/resources/css/table.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="../fragment/bodyHeader.jsp">
    <jsp:param name="titleName" value='<%=URLEncoder.encode("북마크 그룹 목록", "UTF-8")%>'/>
</jsp:include>
    <button onclick="location.href='/wifi/bookmark-group-add'">북마크 그룹 이름 추가</button>
    <table>
        <tr>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>순서</th>
            <th>등록일자</th>
            <th>수정일자</th>
            <th>비고</th>
        </tr>
        <c:forEach items="${groupList}" var="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.groupName}</td>
                <td>${group.order}</td>
                <td>${group.dataRegDate}</td>
                <td>${group.dataUpdDate}</td>
                <td>
                    <a href="/wifi/bookmark-group-edit?id=${group.id}">수정</a>
                    <a href="#" onclick="deleteGroup(${group.id})">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </table>

<script>
    function deleteGroup(id) {
        $.ajax({
            url: "/wifi/bookmark-group-delete",
            type: "POST",
            data: {id : id},
            async: false,
            success: function () {
                alert("데이터가 삭제되었습니다.");
                location.reload();
            },
            error: function () {
                alert("데이터 삭제 실패했습니다.");
                location.reload();
            }
        });
    }
</script>

</body>
</html>
