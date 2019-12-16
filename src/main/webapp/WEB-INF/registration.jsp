<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>Register</h1>
<p>Please fill in this form to create an account.</p>
<form action="registration" method="POST">
    <label for="name"><b>Name </b></label>
    <input type="text" placeholder="Name" name="name" required>
    <p></p>
    <label for="login"><b>Login </b></label>
    <input type="text" placeholder="Login" name="login" required>
    <p></p>
    <label for="age"><b>Age </b></label>
    <input type="number" placeholder="Age" name="age" required>
    <p></p>
    <label for="email"><b>Email </b></label>
    <input type="text" placeholder="Enter Email" name="email" required>
    <p></p>
    <label for="password"><b>Password </b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <p></p>
    <label for="psw-repeat"><b>Repeat Password </b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
    <p></p>
    <button type="submit" class="registerbtn">Register</button>
</form>
<p>Already have an account? <a href="login">Sign in</a>.</p>
</body>
</html>