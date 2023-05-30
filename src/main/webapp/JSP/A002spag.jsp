<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 코드가 흩어져 꼬인 상황을 실타래, 스파게티 코드라고 부름
int num = 0;	
String num_ = request.getParameter("n");
if(num_ != null && !num_.equals("")){
	num = Integer.parseInt(num_);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(num %2 == 0){
		out.print("짝수");
	}else{
		out.print("홀수");
		
	}
	%>

</body>
</html>