<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript" >
<title>ユーザー情報入力</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
<div id="contents">
<h1>ユーザー情報入力画面</h1>
<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.emailErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.loginIdCheckMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.loginIdCheckMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.passwordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session..isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session."><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
</div>

<s:form action="AdminUserCreateConfirmAction">
<table id="vertical-list-table">
	<tr>
		<th scope="row">姓</th>
		<td><s:textfield name="familyName" value="%{#session.familyName}" label="姓" placeholder="姓"/></td>
	</tr>
	<tr>
		<th scope="row">名</th>
		<td><s:textfield name="firstName" value="%{#session.firstName}" label="名" placeholder="名"/></td>
	</tr>
	<tr>
		<th scope="row">姓ふりがな</th>
		<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな"/></td>
	</tr>
	<tr>
		<th scope="row">名ふりがな</th>
		<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" label="名ふりがな" placeholder="名ふりがな"/></td>
	</tr>
	<tr>
		<th scope="row">性別</th>
		<td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" label="性別" placeholder="性別"/></td>
	</tr>
	<tr>
		<th scope="row">メールアドレス</th>
		<td><s:textfield name="email" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス"/></td>
	</tr>
	<tr>
		<th scope="row">ユーザーID</th>
		<td><s:textfield name="userId" value="%{#session.userId}" label="ユーザーID" placeholder="ユーザーID"/></td>
		<s:hidden name="loginId" value="%{session.loginId}"/>
	</tr>
	<tr>
		<th scope="row">パスワード</th>
		<td><s:textfield name="password" value="%{#session.passowrd}" label="パスワード" placeholder="パスワード"/></td>
	</tr>
</table>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="登録"/>
</div>
</div>
</s:form>
<div id="footer">
	<s:iterator value="footer.jsp"/>
</div>
</body>
</html>