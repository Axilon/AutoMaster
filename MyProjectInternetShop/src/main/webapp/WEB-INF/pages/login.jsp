<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <title>Auto Master</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />


    <link rel="icon" href="<c:url value="/static/logo3.png"/>">


    <link rel="stylesheet" href="<c:url value="/static/css/loginStyle.css"/>" type="text/css" />



</head>
<body>
<div class="container" id="logo">
    <img src="<c:url value="/static/logo3.png"/>" alt="logo">
</div>

<div class="login">
    <h1>Авторизация</h1>
    <c:url value="/j_spring_security_check" var="loginUrl"/>

    <form action="${loginUrl}" method="POST">
        <input type="text" name="j_login" placeholder="Введите ваш логин" required="required" />
        <input type="password" name="j_password" placeholder="Введите ваш пароль" required="required" />
        <input type="submit" class="btn btn-primary btn-block btn-large" value="Войти."/>

        <div class="etc-login-form">
            <p>Новый пользователь? <a href="register">создать аккаунт</a></p>
        </div>
        <c:if test="${param.error ne null}">
            <p>Неправильный логин" или пароль!</p>
        </c:if>
    </form>
</div>

<script type="text/javascript" src="<c:url value="/static/js/loginScript.js"/>"> </script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>

</body>
</html>
