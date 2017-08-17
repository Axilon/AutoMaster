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
        <h3><img height="50" width="55" src="<c:url value="/static/logo3.png"/>"/><a href="/admin" > Ложе админа</a></h3>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" >
                    <div class="nav navbar-nav btn-group">

                        <!-- <li><button type="button" id="products_list" class="btn btn-success navbar-btn">Список товаров</button></li> -->

                        <button type="button" id="orders_list" class="btn btn-primary navbar-btn">Список заказов</button>
                        
                    </div>

                    <div  class="nav navbar-nav btn-group navbar-right ">

                        <button type="button" id="users_list" class="btn btn-primary navbar-btn">Список пользователей</button>
                        <button type="button" id="product_type_list" class="btn btn-primary navbar-btn">Список категорий</button>
                        <button type="button" id="products_list" class="btn btn-primary navbar-btn">Список товаров</button>
                        <button type="button" id="go_index" class="btn btn-primary navbar-btn" >На главную</button>
                    </div>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container">
        <form role="form" action="/admin/orders/update/${id}" method="post" >
            <h3>Заказ №${id}</h3>
            Название:
            <input class="form-control form-group" type="text" name="name" value="${name}"><br>
            Цена:
            <input class="form-control form-group" type="text" name="price" value="${price}"><br>
            Имя заказщика:
            <input class="form-control form-group" type="text" name="customerName" value="${customerName}"><br>
            Адрес:
            <input class="form-control form-group" type="text" name="customerAddress" value="${customerAddress}"><br>
            Телефон заказщика:
            <input class="form-control form-group" type="text" name="customerPhone" value="${customerPhone}"><br>
            Статус заказа:
            <input class="form-control form-group" type="text" name="orderStatus" value="${orderStatus}"><br>
            <input type="submit" value="Обновить">
        </form>
        </div>


        <br><br>
        <c:url value="/logout" var="logoutUrl" />
        <p align="right">Click to logout: <a href="${logoutUrl}">LOGOUT</a></p>
    </div>






    <script src="<c:url value="/static/js/admin.js"/> "></script>


</div>
</body>
</html>