<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 표현식 expression language : ${model} = out.print(request.getAtrribute("model");)
// List list = new ArrayList() 의 자료형을 어트리뷰트로 보낼 때 받는다면 ((List)request.getAtrribute("list")).get(0) 하여
// 오브젝트를 자료형 클래스로 캐스트 해야하지만 EL에서 간단하게
// ${list[0]}으로 가능
// HashMap도 가능 함 편하게
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

</body>
</html>