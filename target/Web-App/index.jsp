<html>
<body>
<!-- header -->
<div>
    <h1>Super app!</h1>
</div>

<div>       <!-- content -->
    <div>    <!-- buttons holder -->
        <br>
        <form name="loginForm" method="post" action="hello">
            Username: <input type="text" name="username"/> <br/>
            Password: <input type="password" name="password"/> <br/>
            <input type="submit" value="Login" />
        </form>
        <br>
        <button onclick="location.href='/addUser'">SingUp</button>
    </div>
</div>
</body>
</html>
