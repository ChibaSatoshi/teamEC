<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>UserList</title>
<script type="text/javascript">
	function goAdminUserDeleteAction(){
		document.getElementById("form").action="AdminUserDeleteAction";
	}
	</script>
</head>
<body>
<jsp:include page="adminHeader.jsp"/>

	<div id="contents">
		<h1>ユーザー一覧</h1>
			<s:if test= "userInfoDtoList == null">
				<div class="info">
				誰もいない。
				</div>
			</s:if>
			<s:else>
			<s:form id="form">
				<table border="1">
					<tr>
						<td>#</td>
						<td>ID</td>
						<td>ユーザーID</td>
						<td>パスワード</td>
						<td>姓</td>
						<td>名</td>
						<td>姓かな</td>
						<td>名かな</td>
						<td>性別</td>
						<td>メールアドレス</td>
						<td>ステータス</td>
						<td>ログインフラグ</td>
						<td>登録日</td>
						<td>更新日</td>
						<td>更新</td>
					</tr>
					<s:iterator value="userInfoDtoList">
					<tr>
						<td><s:checkbox name="checkList" value="checked" fieldValue="%{id}"/></td>
						<td><s:property value="id"/></td>
						<td><s:property value="userId"/></td>
						<td><s:property value="password"/></td>
						<td><s:property value="familyName"/></td>
						<td><s:property value="firstName"/></td>
						<td><s:property value="familyNameKana"/></td>
						<td><s:property value="firstNameKana"/></td>
						<td><s:property value="sex"/></td>
						<td><s:property value="email"/></td>
						<td><s:property value="status"/></td>
						<td><s:property value="logined"/></td>
						<td><s:property value="registDate"/></td>
						<td><s:property value="updateDate"/></td>
						<td><a href='<s:url action="AdminUserUpdateAction"><s:param name="id" value="%{id}"/></s:url>'>更新</a></td>
					</tr>
					<s:hidden name="id" value= "%{#id}"/>
					<s:hidden name="userId" value= "%{#userId}"/>
					<s:hidden name="password" value= "%{#password}"/>
					<s:hidden name="familyName" value= "%{#familyName}"/>
					<s:hidden name="firstName" value= "%{#firstName}"/>
					<s:hidden name="familyNameKana" value= "%{#familyNameKana}"/>
					<s:hidden name="firstNameKana" value= "%{#firstNameKana}"/>
					<s:hidden name="sex" value= "%{#sex}"/>
					<s:hidden name="email" value= "%{#email}"/>
					<s:hidden name="status" value= "%{#status}"/>
					<s:hidden name="logined" value= "%{#logined}"/>
					<s:hidden name="registDate" value= "%{#registDate}"/>
					<s:hidden name="updateDate" value= "%{#updateDate}"/>
					</s:iterator>
				</table>
				<div class="submit_btn_box">
				<div id=".contents-btn-set">
				<input type="submit" value="削除" id="form_0" class="submit-btn" onclick="this.form.action='AdminUserDeleteAction';"/>
				</div>
				</div>
				</s:form>
			</s:else>
	</div>

<s:include value="footer.jsp"/>
</body>
</html>