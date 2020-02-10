<%--
  Created by IntelliJ IDEA.
  User: vvarabyeu
  Date: 10-Feb-20
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="POST" action="/input/hello">
        <div>
            <label for="name">Name</label>
            <input id="name" name="name" type="text">
        </div>
        <div>
            <label for="id">Id</label>
            <input id="id" name="id" type="number">
        </div>
        <div>
            <label for="submit">Submit</label>
            <input id="submit" type="submit">
        </div>
    </form>
</body>
</html>
