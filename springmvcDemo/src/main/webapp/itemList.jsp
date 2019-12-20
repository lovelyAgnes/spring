<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息</title>
</head>
<body>
<!-- 使input输入框不可复制的三种方法：disabled，readonly="true"，readonly="readonly"，unselectable="on" -->
  <table border="1">
  <tr>
  <td>id</td>
  <td>name</td>
  <td>price</td>
  <td>createtime</td>
  <td>detail</td>
  </tr>
<c:forEach items="${itemList}" var="item" varStatus="Items">
<tr>
<td><input type="text" name="id" readonly="true" value="${item.id}" /></td>
<td><input type="text" name="name" readonly="true" value="${item.name}" /></td>
<td><input type="text" name="price" readonly="true" value="${item.price}" /></td>
<td><input type="text" name="createtime" readonly="true" value="${item.createtime}" /></td>
<td><input type="text" name="detail" readonly="true" value="${item.detail}" /></td>
</tr>
</c:forEach>
</table>
</body>
</html>