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

                        <button type="button" id="add_product" class="btn btn-success navbar-btn">Добавить товар</button>
                        <button type="button" id="delete_product" class="btn btn-success navbar-btn">Удалить товар</button>


                        <li class="dropdown" >
                            <button href="#" class="btn btn-success navbar-btn dropdown-toggle" type="button"  data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">Категории <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="/admin">Все категории</a></li>
                                <c:forEach items="${productTypes}" var="productType">
                                    <li><a href="/admin/product_type/${productType.id}">${productType.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>

                    </div>

                    <div  class="nav navbar-nav btn-group navbar-right ">

                        <button type="button" id="users_list" class="btn btn-primary navbar-btn">Список пользователей</button>
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
                <td><b>Название</b></td>
                <td><b>Описание</b></td>
                <td><b>Цена</b></td>
                <td><b>Категория</b></td>
                <td></td>

            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><input type="checkbox" name="toDelete[]" value="${product.id}" id="checkbox_${product.id}"/></td>
                    <td>${product.name}</td>
                    <td><textarea name="discription" cols="40" rows="2" readonly>${product.discription}</textarea></td>
                    <td>${product.price}</td>
                    <c:choose>
                        <c:when test="${product.productType ne null}">
                            <td>${product.productType.name}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>
                    <td><a href="<c:url value="/admin/product/${product.id}"/>" class="button btn-danger" >Изменить</a></td>

                </tr>
            </c:forEach>
        </table>



        <br><br>
        <c:url value="/logout" var="logoutUrl" />
        <p align="right">Click to logout: <a href="${logoutUrl}">LOGOUT</a></p>
    </div>

    <script src="<c:url value="/static/js/admin.js"/> "></script>

</div>
</body>
</html>
