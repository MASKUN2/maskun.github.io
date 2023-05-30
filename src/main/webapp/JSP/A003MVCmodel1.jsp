<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 입력과 제어를 담당 ( controller)
// 가져다 쓰는 출력부분 [HTML 부분 View]
// 그 사이를 이동하는 출력 데이터를 Model
// V C M 이 분리되지 않은 상태 : model 1
int num = 0;	
String model;
String num_ = request.getParameter("n");
if(num_ != null && !num_.equals("")){
	num = Integer.parseInt(num_);
}
if(num %2 == 0){
	model = "짝수";
}else{
	model = "홀수";
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=model %>

</body>
</html>