<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/04/02
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // jsp:param 사용시 인코딩 문제로 아래 코드 추가
    request.setCharacterEncoding("UTF-8");
    String param = request.getParameter("titleName");
    String titleName = URLDecoder.decode(param, "UTF-8");
%>

<jsp:include page="../util/loading/loading.jsp" />
<div>
    <div class="body-header-title">
        <H1><%=titleName%></H1>
    </div>
    <div class="body-header-navi">
        <a href="/wifi">홈</a>
        <span> | </span>
        <a href="/wifi/history">위치 히스토리 목록</a>
        <span> | </span>
        <a href="#" onclick="getAllOpenApi()">Open API 와이파이 정보 가져오기</a>
    </div>
</div>


<style>
    .body-header-title {
        padding: 0.1em 0em;
    }
    .body-header-navi {
        padding: 0.2em 0em;
    }
</style>

<script>
    function getAllOpenApi() {
        showLoading();
        location.href="wifi/openApi";
    }
</script>

