<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="1;URL='AdminUserListAction'"/>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
	<div id="contents">
		<h1>ユーザー登録完了画面</h1>
			<div class="success">
			ユーザー登録が完了しました。
			</div>
	</div>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>