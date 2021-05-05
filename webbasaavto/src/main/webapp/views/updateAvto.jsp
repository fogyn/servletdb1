<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 04.05.2021
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upadate</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjs.js"></script>
</head>
<body>
    <h1>
        Update
    </h1>
    <section>
        <div class="container">
            <div class="row">
                <div class="col">

                        <form type="get" action="updateavtobyid" method="GET" class="getform" >
                            <p style="background-color: yellow;">Введиет id авто для редактирования</p>
                            <input type="number" name="id" required>
                            <input type="submit" value="Вывести авто по id" class="sub">
                        </form>

                </div>

            </div>
            <div class="row">
                <div class="col">
                    <div>
                        <c:if test="${updateid=='true'}">

                            <h1 style="display: flex; justify-content: center;">Данные авто по id</h1>
                            <table style="margin: auto;">

                                <tr>
                                    <th>
                                        id
                                    </th>
                                    <th>
                                        name
                                    </th>
                                    <th>
                                        nameAvto
                                    </th>
                                    <th>
                                        engine
                                    </th>
                                    <th>
                                        year
                                    </th>
                                    <th>
                                        color
                                    </th>
                                    <th>
                                        type
                                    </th>
                                </tr>


                                    <tr>
                                        <td>
                                            <c:out value="${avtobyid['id']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${avtobyid['name']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${avtobyid['nameAvto']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${avtobyid['engine']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${avtobyid['year']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${avtobyid['color']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${avtobyid['type']}"></c:out>
                                        </td>
                                    </tr>


                            </table>


                        </c:if>
                        <c:if test="${updateid !='true'}">

                        </c:if>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">

                    <c:if test="${updateid=='true'}">
                        <h5 style="margin: auto; margin-top: 50px; margin-bottom: 50px;">
                            Введите отредактированные данные. Заполнить надо все поля (даже если значение не изменилось)
                        </h5>
                        <form type="post" action="updateavtobyid" method="POST" class="postform" >
                            <input type="number" name="id" value="${avtobyid['id']}" hidden>
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
                                <input type="submit" value="Редактировать" class="sub">
                            </div>

                        </form>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <c:out value="${update}"></c:out>
                </div>

            </div>
        </div>
    </section>

    <hr>
    <a href="../index.jsp">Главная</a>
</body>
</html>
