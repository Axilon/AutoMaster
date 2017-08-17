<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auto Master</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>


<div>
    <div class="container">
        <h3><img height="50" width="55" src="<c:url value="../static/logo3.png"/>"/><a href="/admin" > Ложе админа</a></h3>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" >
                    <div class="nav navbar-nav btn-group">

                        <!-- <button type="button" id="products_list" class="btn btn-success navbar-btn">Список товаров</button> -->

                        <button type="button" id="delete_user" class="btn btn-danger navbar-btn">Удалить пользователя</button>


                    </div>

                    <div  class="nav navbar-nav btn-group navbar-right ">

                        <button type="button" id="products_list" class="btn btn-primary navbar-btn">Список товаров</button>
                        <button type="button" id="product_type_list" class="btn btn-primary navbar-btn">Список категорий</button>
                        <button type="button" id="orders_list" class="btn btn-primary navbar-btn">Список заказов</button>
                        <button type="button" id="go_index" class="btn btn-primary navbar-btn" >На главную</button>
                    </div>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <table class="table table-striped">
            <thead>
            <tr>
                <td></td>
                <td><b>Логин</b></td>
                <td><b>Email</b></td>
                <td><b>Номер телефона</b></td>


            </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><input type="checkbox" name="toDelete[]" value="${user.id}" id="checkbox_${product.id}"/></td>
                    <td>${user.login}</td>

                    <c:choose>
                        <c:when test="${user.email ne null}">
                            <td>${user.email}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Не указан</td>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${user.phone ne null}">
                            <td>${user.phone}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Не указан</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>


        <br><br>
        <c:url value="/logout" var="logoutUrl" />
        <p align="right">Click to logout: <a href="${logoutUrl}">LOGOUT</a></p>
    </div>

    <script src="<c:url value="../static/js/admin.js"/> "></script>

</div>
</body>
</html>