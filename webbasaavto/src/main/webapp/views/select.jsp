<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjs.js"></script>
</head>
<body>



    <section class="select" style="margin-top: 100px">
        <div class="container">
            <div class="row r0">
                <div class="col-4" style="margin: auto; margin-bottom: 50px;">
                    <h1>
                        Выборка из базы
                    </h1>
                </div>
            </div>
            <div class="row r1" style="margin-bottom: 50px;">
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="getallavto" method="GET" class="getform" >
                        <input type="submit" value="Выбрать все" class="sub">
                    </form>
                </div>
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="getallname" method="GET" class="getform" >
                        <input type="submit" value="Все производители" class="sub">
                    </form>
                </div>
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="getallname&avto" method="GET" class="getform" >
                        <input type="submit" value="Выбрать всех производителей и авто" class="sub">
                    </form>
                </div>

            </div>
            <hr>
            <div class="row r2" style="margin-bottom: 50px;">

                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="getnamemaxavto" method="GET" class="getform" >
                        <input type="submit" value="Вывести производителя с max авто" class="sub">
                    </form>
                </div>
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="getnameminavto" method="GET" class="getform" >
                        <input type="submit" value="Вывести производителя с min авто" class="sub">
                    </form>
                </div>
            </div>
            <hr>
            <div class="row r3" style="margin-bottom: 50px;">
                <div class="col">
                    <form type="get" action="getallavtobyyear" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введите год для поиска</p>
                        <input type="number" name="year" required>
                        <input type="submit" value="Вывести авто по году" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getallavtobeetwinyear" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введите год, с которого начать поиск</p>
                        <input type="number" name="yearmin" required>
                        <p style="background-color: yellow;">Введиет год, которым закончить поиск</p>
                        <input type="number" name="yearmax" required>
                        <input type="submit" value="Вывести авто в интервале лет" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getallavtobyname" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введиет название производителя</p>
                        <input type="text" name="name" required>
                        <input type="submit" value="Вывести авто указанного производителя" class="sub">
                    </form>
                </div>

            </div>
            <hr>
            <div class="row r4" style="margin-bottom: 50px;">

                <div class="col">
                    <form type="get" action="getallavtobycolor" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введиет цвет авто</p>
                        <input type="text" name="color" required>
                        <input type="submit" value="Вывести авто по цвету" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getallavtobyengine" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введиет объем двигателя</p>
                        <input type="number" name="engine" required>
                        <input type="submit" value="Вывести авто по объему двигателя" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getallavtobytype" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введиет тип кузова</p>
                        <input type="text" name="type" required>
                        <input type="submit" value="Вывести авто по кузову" class="sub">
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col" style="display: flex; justify-content: center;">
                    <div class="home" style="display: flex; justify-content: center; border: 2px solid blue; width: 200px;">
                        <a href="../index.jsp"><h3>Главная</h3></a>
                    </div>
                </div>
            </div>
        </div>
        <hr>
    </section>

    <section class="rez">
        <div class="container">
            <div class="row all">
                <div class="col">
                    <div>
                        <!--вывод всей информации из базы-->
                        <c:if test="${allbool=='true' || yearbetweenbool=='true' || yearbool=='true'}">
                            <h1 style="display: flex; justify-content: center;">данные из базы</h1>
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
                                <c:forEach var="el" items="${all}" varStatus="b">

                                    <tr>
                                        <td>
                                            <c:out value="${el['id']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${el['name']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${el['nameAvto']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${el['engine']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${el['year']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${el['color']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${el['type']}"></c:out>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </table>


                        </c:if>

<!--вывод производителей и количество их авто-->
                        <c:if test="${namecol=='true'}">
                            <h1 style="display: flex; justify-content: center;">Все производители  и количество авто в базе</h1>
                            <div style="margin: auto;">
                                <c:forEach var="manufactory" items="${names_cols}" varStatus="b">
                                    <div class="name2">
                                        <c:out value="${b.index+1}. ${manufactory['name']} - ${manufactory['count']}"></c:out>
                                    </div>

                                </c:forEach>
                            </div>
                        </c:if>
                        <!--вывод производителя с максимальным числом авто-->
                        <c:if test="${namemaxbool=='true'}">
                            <h3 style="display: flex; justify-content: center; width: 900px; margin: auto">Наименование производителя с максимальным числом авто в базе</h3>
                            <div style="margin: auto;">
                                <c:forEach var="av" items="${namemax}" varStatus="b">
                                    <div class="name2" style="display: flex; justify-content: center;">
                                        <c:out value="${av['name']} - ${av['count']}"></c:out>
                                    </div>
                                </c:forEach>

                            </div>
                        </c:if>

                        <!--вывод производителя с минимальным числом авто-->
                        <c:if test="${nameminbool=='true'}">
                            <h3 style="display: flex; justify-content: center; width: 900px; margin: auto">Наименование производителя с минимальным числом авто в базе</h3>
                            <div style="margin: auto;">
                                <c:forEach var="av" items="${namemin}" varStatus="b">
                                    <div class="name2" style="display: flex; justify-content: center;">
                                        <c:out value="${av['name']} - ${av['count']}"></c:out>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>


                        <!--вывод авто по конкретному году если такого авто нет-->
                        <c:if test="${yearboolnot=='true' || yearboolbetweennot =='true'}">
                            <h3 style="display: flex; justify-content: center; width: 900px; margin: auto">Наименование производителя с минимальным числом авто в базе</h3>
                            <div style="margin: auto;">
                                <div class="name2" style="display: flex; justify-content: center;">
                                    <c:out value="${avto_notyear}"></c:out>
                                </div>
                            </div>
                        </c:if>




                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="rez">
        <div class="container">
            <div class="row all">
                <div class="col">
                    <c:if test="${allname=='true'}">
                        <h1 style="display: flex; justify-content: center;">Все производители</h1>
                        <div style="margin: auto;">
                            <c:forEach var="name" items="${names}" varStatus="b">
                                <div class="name2">
                                    <c:out value="${b.index+1}. ${name}"></c:out>
                                </div>

                            </c:forEach>
                        </div>


                    </c:if>
                </div>
            </div>

        </div>

    </section>











    <hr>


</body>
</html>
