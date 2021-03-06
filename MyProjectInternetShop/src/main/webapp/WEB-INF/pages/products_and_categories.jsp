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


    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/myStyle.css"/>" />

    <!-- bootstrap -->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
    <!--
    <!-- bootstrap -->

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/demo/styles/demo.css"/>" media="screen"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/icons.css"/>"/>


    <script type="text/javascript" src="<c:url value="/static/js/modernizr.custom.js"/>"></script>

</head>
<body>
<header class="header">
    <div id="demo_navi">
        <div class="navbar navbar-inverse navbar-static-top" role="navigation" id="topNavbar">

            <a href="/" rel="nofollow">
                <div class="logo"><b><font color = #c3e425>AUTO</font>MASTER</b></div>
            </a>
            <div class="container">
                <div class="navbar-header">

                    <button type="button" class="navbar-toggle " data-toggle="collapse" data-target="#resposive-menu2">
                        <!-- кнопка для развёртывания и свёртывания навигационного меню (на устройствах с маленьким разрешением)-->

                        <span class="sr-only">Open navigation </span>
                        <!-- sr-only указывает что её будет видно только на скрин ридерах -->
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>


                </div>
                <div class="collapse navbar-collapse navbar-right" id="resposive-menu2" align="center">
                    <ul class="nav navbar-nav navbar-right">


                            <c:if test="${products ne null && productTypes ne null}">
                                <li class="dropdown" >
                                    <button href="#" class="btn btn-success navbar-btn dropdown-toggle" type="button"  data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="false">Категории <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="/products">Все категории</a></li>
                                        <c:forEach items="${productTypes}" var="productType">
                                            <li><a href="/categories/${productType.id}"
                                                    <c:if test="${productType_id ne null && productType_id eq productType.id}"> selected</c:if>
                                            >${productType.name}</a></li>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:if>


                        <form class="navbar-form navbar-left" method="post" action="/search">
                            <input type="text" class="form-control" placeholder="Search..." name="pattern">
                            <input  class="btn btn-success" type="submit" value="Поиск"/>
                        </form>

                        <!--  выпадающая из кнопки менюшка -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-user" ></span>
                                <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/userCabinet">Личный кабинет</a></li>

                                <!-- визуально расделяет пункты друг от друга -->
                                <li class="divider"></li>
                                <c:url value="/logout" var="logoutUrl" />
                                <li><a href="${logoutUrl}">Выход</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="/shoppingCart"> <span class="glyphicon glyphicon-shopping-cart" ></span>
                                Корзина</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="container" id="main">
    <div class="container catalog">

        <div class="row">
            <c:choose>
                <c:when test="${products ne null && productTypes ne null}">
                     <c:forEach items="${products}" var="product">
            <div class="col-xs-6 col-sm-3">
                <div class="card">




                    <img src="<c:url value="/static/loadedPictures/${product.picture}"/>"  id="img-card"/>

                    <br>
                    <div class="card-content">
                        <h4 class="card-title">
                            <c:out value="${product.name}"/>
                        </h4>
                        <hr>
                        <div class="card-price">
                            <p>Цена:  <c:out value="${product.price}"/> грн.</p>
                        </div>
                    </div>
                    <div class="card-read-more">
                        <a href="/products/${product.id}">
                            <button id="add_to_shopping_cart" class="btn btn-link btn-block">
                                Перейти к товару
                            </button>
                        </a>
                    </div>

                </div>
            </div>

            </c:forEach>
            </c:when>
                <c:when test="${justProductTypes ne null}">
                    <c:forEach items="${justProductTypes}" var="productTypes">
                        <div class="col-xs-6 col-sm-3">
                            <div class="card">
                                <img src="<c:url value="/static/loadedPictures/${productTypes.picture}"/>" id="img-card" />
                                <br >
                                <div class="card-content">
                                    <h4 class="card-title">
                                        <c:out value="${productTypes.name}"/>
                                    </h4>
                                </div>
                                <div class="card-read-more">
                                    <a href="/categories/${productTypes.id}">
                                        <button  class="btn btn-link btn-block" >
                                            Перейти в каталог
                                        </button>
                                    </a>
                                </div>

                            </div>
                        </div>

                    </c:forEach>
                </c:when>
            </c:choose>
            <c:if test="${(product.id%4)eq 0 || (justProductType.id % 4) eq 0}">
        </div>
        <div class="row">

            </c:if>
           </div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${allPages ne null}">
                        <c:forEach var="i" begin="1" end="${allPages}">

                            <li <c:if test="${(i - 1)eq 1}"> hidden="hidden" </c:if> >
                                <a href="/products?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a>
                            </li>

                        </c:forEach>
                    </c:if>
                    <c:if test="${byProductTypePages ne null}">
                        <c:forEach var="i" begin="1" end="${byProductTypePages}">
                            <li><a href="/categories/${productType_id}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                        </c:forEach>
                    </c:if>
            </ul>
        </nav>


        </div>
    </div>


<!-- Навигация сайта -->
<div id="navigation">
    <nav id="bt-menu" class="bt-menu ">
        <br>
        <br>
        <br>
        <a href="#" class="bt-menu-trigger "><span>Меню</span></a>
        <ul>
            <br>
            <br>
            <li><a href="/">Главная</a></li>
            <li><a href="/products">Товары</a></li>
            <li><a href="/categories">Категории</a></li>
            <li><a href="/faq">FAQ</a></li>
            <li><a href="/contacts">Контакты</a></li>
        </ul>
        <ul>
            <li><a href="#" class="bt-icon icon-twitter">Twitter</a></li>
            <li><a href="#" class="bt-icon icon-gplus">Google+</a></li>
            <li><a href="#" class="bt-icon icon-facebook">Facebook</a></li>
            <li><a href="#" class="bt-icon icon-github">icon-github</a></li>
        </ul>
    </nav>
</div>
<!-- Навигация сайта -->
<!-- Footer-->
<div class="container-fluid">

    <footer class="footer-bs">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-sm-3 col-md-3 footer-brand animated fadeInLeft">
                    <img src="<c:url value="/static/logo3.png"/>" alt="logo" id="logotipe">
                    <p>Широкий ассортимент товаров высокого качества и по доступным ценам для вашего автомобиля </p>
                    <p>© Интернет-магазин «Auto Master™» 2017</p>
                </div>
                <div class="col-lg-4 col-sm-4 col-md-4 footer-nav animated fadeInUp">
                    <h4>Карта сайта —</h4>
                    <hr>
                    <div class="col-lg-6 col-sm-6 col-md-6">
                        <ul class="pages">
                            <li><a href="/">Главная</a></li>
                            <li><a href="/products">Товары</a></li>
                            <li><a href="/categories">Категории</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-md-6">

                        <ul class="list">
                            <li><a href="/faq">FAQ <span class="glyphicon glyphicon-question-sign" ></span></a></li>
                            <li><a href="/contacts">Контакты  <span class="glyphicon glyphicon glyphicon-earphone" ></span>
                            </a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-2 col-sm-2 col-md-2 footer-social animated fadeInDown">
                    <h4><span class="glyphicon glyphicon-time" ></span> Часы работы:</h4>
                    <hr>
                    <p>
                    <h5>Интернет магазина</h5>
                    Пн - Вс: 9:00-20:00 <br>
                    </p>

                </div>
                <div class="col-lg-3 col-sm-3 col-md-3 footer-ns animated fadeInRight">
                    <br>
                    <hr>
                    <p>
                    <h5>Магазин на рынке "Лепсе"</h5>
                    Пн: 9:00-16:00 <br>
                    Вт-Вс: 9:00-18:00 <br>
                    </p>
                </div>
            </div>
        </div>
    </footer>

</div>






<script type="text/javascript" src="<c:url value="/static/js/classie.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/borderMenu.js"/>"></script>

</body>
</html>