<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 19.01.2023
  Time: 00:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<section class="vh-100" style="background-color: #508bfc;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h3 class="mb-5">Sign up <br> <%if (request.getAttribute("isValidData") != null && !(boolean)request.getAttribute("isValidData")){%>
                            <%="You did not enter all fields or same login have been created yet"%>
                            <br>
                            <%= "Enter all fields. If reason is not in that try to change login"%>
                            <%}%></h3>   <%--!!!!!!!!!!!!!!!!!!!!!!!!!--%>
                        <form action="/signUp" method="post" class="form-outline mb-4">
                            <input type="text" id="typeEmailX-2" name="login" class="form-control form-control-lg" />
                            <label class="form-label" for="typeEmailX-2">Login</label>
                            <input type="password" id="typePasswordX-2" name="password" class="form-control form-control-lg" />
                            <label class="form-label" for="typePasswordX-2">Password</label>
                            <input type="text" <%--id="typeEmailX-2"--%> name="name" class="form-control form-control-lg" />
                            <label class="form-label" for="typePasswordX-2">Name</label>
                            <br>
                            <input class="btn btn-primary btn-lg btn-block" type="submit" value="OK">
                            <br>
                        </form>

                        <form action="/login" method="get">
                            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Back">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
