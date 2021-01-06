<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息</title>
</head>
<body>
<!-- 使input输入框不可复制的三种方法：disabled，readonly="true"，readonly="readonly"，unselectable="on" -->
  <table border="1">
  <tr>
  <td>id</td>
  <td>name</td>
  <td>age</td>
  <td>sex</td>
  <td>tel</td>
  <td>addr</td>  
  </tr>
<c:forEach items="${userList}" var="user" varStatus="User">
<tr>
<td><input type="text" name="id" readonly="true" value="${user.id}" /></td>
<td><input type="text" name="name" readonly="true" value="${user.name}" /></td>
<td><input type="text" name="age" readonly="true" value="${user.age}" /></td>
<td><input type="text" name="sex" readonly="true" value="${user.sex}" /></td>
<td><input type="text" name="tel" readonly="true" value="${user.tel}" /></td>
<td><input type="text" name="addr" readonly="true" value="${user.addr}" /></td>
</tr>
</c:forEach>
</table>
</body>
</html>