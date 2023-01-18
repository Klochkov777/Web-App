
<jsp:useBean id="name" scope="request" type="java.lang.String"/>
<jsp:useBean id="users" scope="request" type="java.util.List"/>
<%@ page import="java.util.List" %>
<%@ page import="pers.klochkov.firstApp.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="users" type="java.util.List<pers.klochkov.firstApp.model.User>"--%>
<html>
<body>
<div>
<table>
    <tr>
        <td>login</td>
        <td>name</td>
    </tr>

<%List<User> userList = (List<User>) request.getAttribute("users");%>

    <%
        for (int i = 0; i < userList.size(); i++) {%>
    <tr>
    <td><%=userList.get(i).getLogin()%></td>
    <td><%=userList.get(i).getName()%></td>
<nobr>
    </tr>
    <%}%>


</table>
</div>

<p>Name: ${name}</p>
<p>Age: ${age}</p>





</body>
</html>