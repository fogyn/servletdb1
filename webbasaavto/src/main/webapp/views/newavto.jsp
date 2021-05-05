<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 04.05.2021
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>NewAvto</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjs.js"></script>
</head>
<body>
    <h1>new avto</h1>




    <section class="new">
        <div class="container">
            <div class="row">
                <div class="col">
                    <form type="post" action="newavto" method="POST" class="postform" >
                        <div>
                            <label style="background-color: yellow;">Производитель</label>
                            <input type="text" name="name" required>
                        </div>
                        <div>
                            <label style="background-color: yellow;">Модель</label>
                            <input type="text" name="nameAvto" required>
                        </div>
                        <div>
                            <label style="background-color: yellow;">Объем двигателя в см3</label>
                            <input type="number" name="engine" required>
                        </div>
                        <div>
                            <label style="background-color: yellow;">Год выпуска</label>
                            <input type="number" name="year" required>
                        </div>
                        <div>
                            <label style="background-color: yellow;">Цвет</label>
                            <input type="text" name="color" required>
                        </div>
                        <div>
                            <label style="background-color: yellow;">Кузов</label>
                            <input type="text" name="type" required>
                        </div>
                        <div>
                            <input type="submit" value="Создать" class="sub">
                        </div>

                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <c:out value="${newavto}"></c:out>
                </div>
            </div>
        </div>
    </section>

    <hr>
    <a href="../index.jsp">Главная</a>
</body>
</html>
