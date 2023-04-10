<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/04/10
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
  <link href="/resources/css/table.css" rel="stylesheet" type="text/css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="../fragment/bodyHeader.jsp">
  <jsp:param name="titleName" value='<%=URLEncoder.encode("북마크 목록", "UTF-8")%>'/>
</jsp:include>
<table>
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>와이파이 명</th>
        <th>등록일자</th>h>
        <th>비고</th>
    </tr>
    <c:forEach items="${bookmarkList}" var="bookmark">
        <tr>
            <td>${bookmark.id}</td>
            <td>${bookmark.bookmarkGroupName}</td>
            <td>${bookmark.mgrName}</td>
            <td>${bookmark.dataRegDate}</td>
            <td>
                <a href="#" onclick="deleteGroup(${bookmark.id})">삭제</a>
            </td>
        </tr>
    </c:forEach>
</table>

<script>
    function deleteGroup(id) {
        $.ajax({
            url: "/wifi/bookmark-list",
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
