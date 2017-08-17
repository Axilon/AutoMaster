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


<div class="register">

    <h1>Регистрация</h1>
    <div class="row main">
        <div class="main-login main-center">
            <c:url value="/newuser" var="regUrl" />
            <form role="form" method="POST" action="${regUrl}">

                <div class="form-group">
                    <label for="login" class="cols-sm-2 control-label">Логин</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="login" id="login"  required="required"  placeholder="Введите ваш логин" maxlength="20"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label"> Email</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <input type="email" class="form-control" name="email" id="email"  placeholder="Введите ваш Email"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="phone" class="cols-sm-2 control-label">Номер мобильного телефона</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-mobile fa" aria-hidden="true"></i></span>
                            <input type="tel" class="form-control" name="phone" id="phone"  placeholder="+38(000)000-00-00"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Пароль</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="password" id="password"  required="required" placeholder="Введите ваш пароль"
                                   min="4" maxlength="30"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Повторите пароль</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="passwordRepeat" id="password"  required="required" placeholder="Введите повторно ваш пароль"
                                   min="4" maxlength="30"/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <input type="submit" class="btn btn-primary btn-block btn-large" value="Регистрация."/>
                </div>

                <c:if test="${wrongPasswords ne null}">
                    <p>Пароли не совпадают!</p>
                </c:if>
                <c:if test="${exists ne null}">
                    <p>Пользователь с таким логином уже существует!</p>
                </c:if>
            </form>
        </div>
    </div>

    <div class="etc-login-form">
        <p>У Вас уже есть аккаунт? <a href="/login">Войти в учётную запись</a></p>
    </div>


<script type="text/javascript" src="<c:url value="/static/js/loginScript.js"/>"> </script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>

</body>
</html>
