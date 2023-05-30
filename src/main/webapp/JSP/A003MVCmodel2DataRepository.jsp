<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 저장소 중 페이지 내부의 컨텍스트 저장소 : Page
pageContext.setAttribute("key", "욜로");

//만약 하위, 상위 저장소에 키 값이 동일한 데이터가 저장되어 있다면
// 하위 저장소가 우선순위가 높다. 만약 session에 key : 옵션 이라면 욜로를 꺼내게 된다.
// 여기서 저장소를 한정하는 명령어가 Scope.(key)
// {} 안에 지정. PageScope, requestScope, sessionScope, acpplicationScope
// 그 외로 EL에서 Param. 등 파라미터, 헤더 쿠키도 가져올 수 있음
// pagecontext 도 있으며 사용법이 조금 다름

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${model}
	${names[0]}
	${notice.title}
	${pageScope.key}
	${requestScope.key} 
	<!-- reqeustScope.key는 출력안됨 -->

</body>
</html>