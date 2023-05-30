<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// model 2 : C V가 분리된 상태. 실행속도가 빠름
// 분리된 C -> V 보내는게 디스패처를 통해 포워딩함
// 포조클래스 : 디스패처 서블릿으로 부터 분리한 상위 컨트롤러로써
// 일반 퍼블릿 자바 클래스를 
// 비지니스로직으로 간직하고 디스패처 서블릿의 요청에 따라 프로세스

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= request.getAttribute("model") %>

</body>
</html>