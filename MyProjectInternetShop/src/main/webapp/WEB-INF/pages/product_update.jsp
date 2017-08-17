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
                        <button type="button" id="products_list" class="btn btn-success navbar-btn">Список товаров</button>


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


            <h3>Изменение данных товара</h3>
            <div class="container">

                <c:url value="/admin/product/${product_id}/update" var="updateProduct" />

                <form role="form" action="${updateProduct}" method="post" >

                    Категория: <br>
                    <select class="selectpicker form-control form-group" name="productType">
                        <option value="-1">Не выбрана</option>
                        <c:forEach items="${productTypes}" var="productType">
                            <option value="${productType.id}"
                                     <c:if test="${product.productType.id eq productType.id}"> selected</c:if>
                            >${productType.name}</option>
                        </c:forEach>
                    </select>
                    Название:<br>
                    <input class="form-control form-group" type="text" name="name" value="${product.name}" ><br>
                    Описание: <br>
                    <input type="textarea" cols="40" rows="1" class="form-control form-group"  name="discription"
                           value="${product.discription}"><br>
                    Цена: <br>
                    <input class="form-control form-group" type="text" name="price" value="${product.price}" ><br>
                    <input type="submit" value="Обновить данные">
                </form>

                <br>
                <hr>
                <br>

                <form role="form" action="/admin/product/${product.id}/photo_update" method="post" enctype="multipart/form-data">
                    Изображение: <br>
                    <img src="<c:url value="/static/loadedPictures/${product.picture}"/>" type="file" name="picture" height="150px" width="150px">
                    <br>
                    <br>
                    <input type="file" name="picture"><br>
                    <input type="submit" value="Обновить изображение">
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
