<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP 범위별 내장 객체</title>
</head>
<body>

	<h3>범위별 객체에 세팅된 값(속성) 얻어오기</h3>
	<pre>
		- 제출된 파라미터 얻어오는 EL : \${param.key}
		
		- 범위별 객체에 세팅된 값 얻어오는 EL
		1) \${000Scope.key}	 ex) \${requestScope.key}
		
		2) ${key}
		-> 좁은 범위 객체부터 탐색하여 일치하는 key가 있으면 얻어옴
	</pre>
	
	<%
	
		// page scope 객체에 값 세팅
		pageContext.setAttribute("pageValue", "page scope 객체에 세팅한 값");
	
	%>
	
	<p>page scope : ${pageScope.pageValue}</p>
	<p>request scope : ${requestScope.requestValue}</p>
	<p>session scope : ${sessionScope.sessionValue}</p>
	<p>application scope : ${applicationScope.applicationValue}</p>
	
	<p>request scope : ${requestScope.requestValue}</p>
	<p>sessoion scope : ${sessionScope.sessionValue}</p>
	<p>application scope : ${applicationScope.applicationValue}</p>
	
	<a href="/el/check">객체 범위 확인페이지로 이동</a>

</body>
</html>