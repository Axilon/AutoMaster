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


                        <button type="button" id="add_product_type" class="btn btn-success navbar-btn">Добавить категорию</button>
                        <button type="button" id="delete_product_type" class="btn btn-success navbar-btn">Удалить категорию</button>
                        <button type="button" id="product_type_list" class="btn btn-success navbar-btn">Список категорий</button>


                    </div>

                    <div  class="nav navbar-nav btn-group navbar-right ">

                        <button type="button" id="users_list" class="btn btn-primary navbar-btn">Список пользователей</button>
                        <button type="button" id="products_list" class="btn btn-primary navbar-btn">Список товаров</button>
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
                <td><b>Название</b></td>
                <td><b>Изображение</b></td>
                <td></td>

            </tr>
            </thead>
            <c:forEach items="${productTypes}" var="productType">
                <tr>
                    <td><input type="checkbox" name="toDelete[]" value="${productType.id}" id="checkbox_${productType.id}"/></td>
                    <td>${productType.name}</td>
                    <td><img src="<c:url value="/static/loadedPictures/${productType.picture}"/>" name="picture" height="75px" width="75px" /></td>
                    <td><a href="/admin/product_type/${productType.id}/change">Изменить</a></td>
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