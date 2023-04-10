<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/04/10
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <meta charset="UTF-8">
    <link href="/resources/css/table.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="../fragment/bodyHeader.jsp">
    <jsp:param name="titleName" value='<%=URLEncoder.encode("북마크 그룹 추가", "UTF-8")%>'/>
</jsp:include>
    <form id="groupAddForm" action="/wifi/bookmark-group-add" method="post">
        <table>
            <tr>
                <th>북마크 이름</th>
                <td style="background-color: darkgrey"><input type="text" name="groupName" value=""></td>
            </tr>
            <tr>
                <th>순서</th>
                <td><input type="number" name="order" value=""></td>
            </tr>
        </table>
        <div style="text-align: center">
            <button style="margin:auto" type="submit">추가</button>
        </div>
    </form>

<!-- jQuery와 Ajax를 사용한 요청 -->
<script>
    $(document).ready(function() {
        $('#groupAddForm').submit(function(e) {
            e.preventDefault(); // form의 기본 동작을 막음

            // Ajax 요청 생성
            $.ajax({
                url: '/wifi/bookmark-group-add', // Ajax 요청을 처리할 서블릿의 URL
                method: 'POST', // Ajax 요청의 HTTP 메소드
                data: $('#groupAddForm').serialize(), // Ajax 요청에 전송할 데이터
                success: function(response) { // Ajax 요청이 성공한 경우 실행될 콜백 함수
                    alert("성공적으로 추가되었습니다.");
                    // 페이지 이동
                    window.location.href = '/wifi/bookmark-group';
                },
                error: function(xhr, status, error) { // Ajax 요청이 실패한 경우 실행될 콜백 함수
                    console.log(error); // 에러 메시지를 콘솔에 출력
                    alert("데이터 추가에 실패했습니다.");
                    // 페이지 이동
                    window.location.reload();
                }
            });
        });
    });
</script>

</body>
</html>
