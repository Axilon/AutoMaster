<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Auto Master</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />


    <link rel="icon" href="<c:url value="/static/logo3.png"/>">
</head>
<body>
<div align="center">
    <h1>В доступе отказано ${login}!</h1>

    <c:url value="/" var="Main" />
    <p>Нажмите чтобы вернуться на <a href="${Main}">главную страницу</a></p>
</div>
</body>
</html>