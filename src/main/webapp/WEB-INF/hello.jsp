<%--
  Created by IntelliJ IDEA.
  User: vvarabyeu
  Date: 05-Feb-20
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>${msg}</title>
</head>
<body>

${defaultMsg}
<table>
    <tr>
        <td>default Name :</td>
        <td>${defaultEmp.name}</td>
    </tr>
    <tr>
        <td>default ID :</td>
        <td>${defaultEmp.id}</td>
    </tr>
    <tr>
        <td>------</td>
        <td>---------------------------------</td>
    </tr>
</table>


${msg}
<table>
    <tr>
        <td>Name :</td>
        <td>${emp.name}</td>
    </tr>
    <tr>
        <td>ID :</td>
        <td>${emp.id}</td>
    </tr>
</table>
</body>
</html>
