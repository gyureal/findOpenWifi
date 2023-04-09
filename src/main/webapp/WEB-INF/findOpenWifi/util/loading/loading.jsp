<%--
  Created by IntelliJ IDEA.
  User: yonggyujeong
  Date: 2023/04/09
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loading</title>
    <link rel="stylesheet" href="/resources/css/loading.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<script>
  // loading.html 파일 가져오기
  var loadingHtml = null;
  $.ajax({
    url: "/resources/loading.html",
    async: false,
    success: function(data) {
      loadingHtml = data;
    }
  });

  // 유틸 함수 정의
  function showLoading() {
    // 가져온 HTML 파일 현재 페이지에 추가하기
    $("body").append(loadingHtml);

    // 로딩중 표시 보이기
    $("#loading").show();
  }

  function hideLoading() {
    // 로딩중 표시 숨기기
    $("#loading").remove();
  }
</script>

</body>
</html>
