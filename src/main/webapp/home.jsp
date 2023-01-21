<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 20.01.2023
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

                        <h3 class="mb-5">Home page</h3>
                        <form action="/table" method="get" class="form-outline mb-4">
                            <br>
                            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Get table">
                        </form>
                        <br>
                        <br>
                        <br>
                        <br>

                        <form action="/logout" method="post" class="form-outline mb-4">
                            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Logout">
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
