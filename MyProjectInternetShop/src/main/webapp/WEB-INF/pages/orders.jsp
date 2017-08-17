<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auto Master</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="icon" href="<c:url value="/static/logo3.png"/>">
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

                        <!-- <li><button type="button" id="products_list" class="btn btn-success navbar-btn">Список товаров</button></li> -->


                        <button type="button" id="delete_order" class="btn btn-success navbar-btn">Удалить заказ</button>


                        <li class="dropdown" >
                            <button href="#" class="btn btn-success navbar-btn dropdown-toggle" type="button"  data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">Категории <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/orders_list">Все заказы</a></li>
                                <c:forEach items="${orders_status}" var="orderStatus">
                                    <li><a href="/admin/orders_list/${orderStatus.name}">${orderStatus.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>

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

        <table class="table table-striped">
            <thead>
            <tr>
                <td></td>
                <td><b>Товар</b></td>
                <td><b>Цена</b></td>
                <td><b>Заказщик</b></td>
                <td><b>Адрес</b></td>
                <td><b>Телефон</b></td>
                <td><b>Статус</b></td>
                <td><b>Доставка</b></td>
                <td></td>

            </tr>
            </thead>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td><input type="checkbox" name="toDelete[]" value="${order.id}" id="checkbox_${order.id}"/></td>
                    <td>${order.name}</td>
                    <td>${order.price}</td>
                    <td>${order.customerName}</td>
                    <td>${order.customerAddress}</td>
                    <td>${order.customerPhone}</td>
                    <td>${order.orderStatus}</td>
                    <td>${order.deliveryType}</td>
                    <td><a href="<c:url value="/admin/orders/${order.id}"/>">Изменить</a></td>
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