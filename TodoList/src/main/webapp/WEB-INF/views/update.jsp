<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>할 일 수정</h4>
	<form action="/todo/update" method="get">
		<div>
		제목 : <input type="text" name="title">
		</div>
		<div>
		<textarea rows="3" cols="50" name="update"
		placeholder="상세 내용 입력.."></textarea>
		</div>
		
		<button>수정하기</button>
	</form>

</body>
</html>