<%--@elvariable id="users" type="List<UserDto>"--%>
<%@ page import="pers.klochkov.firstApp.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="pers.klochkov.firstApp.dto.UserDto" %><%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 21.01.2023
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div>
    <table class="table table-dark table-striped">
        <tr>
            <td>login</td>
            <td>name</td>
        </tr>

        <%List<UserDto> userList = (List<UserDto>) request.getAttribute("users");%>

        <%
            for (int i = 0; i < userList.size(); i++) {%>
        <tr>
            <td><%=userList.get(i).getLogin()%></td>
            <td><%=userList.get(i).getName()%></td>

        </tr>
        <%}%>

    </table>
    <br>
    <br>
    <br>
    <form action="/logout" method="post" class="form-outline mb-4">
        <input class="btn btn-primary btn-lg btn-block" type="submit" value="Logout">
    </form>
</div>

<p>Name: ${users}</p>

</body>
</html>

