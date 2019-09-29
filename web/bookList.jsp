<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>图书后台管理</title>
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">

    </head>

    <body>
       <header>
            <div class="container">
                    <nav>
                            <a href="/searchBook" >图书信息管理</a>
                    </nav>
                    <nav>
                            <a href="/selectCategory" >分类管理</a>
                    </nav>

            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>图书管理系统</h1>
                    <p>图书信息管理</p>
                </div>
            </div>
        </section>
        <section class="main">


            <div class="container">
                <form class="form-horizontal" action="/searchBook" method="post">
                <div class="form-group"  style="float: right;">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
                <div class="form-group" style="float: right;width: 300px;">
                    <div class="col-sm-8">
                        <input name="searchContent" class="form-control" id="searchContent"
                        placeholder="输入要查询的分类" style="width: 250px">
                    </div>
                </div>


            </form>
            </div>
            <div class="container">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>图书编号</th>
                        <th>图书名称</th>
                        <th>分类</th>
                        <th>价格</th>
                        <th>图书封面</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.bookList}" var="book" varStatus="idx">
                            <tr id="tr1">
                                <td>${idx.index+1}</td>
                                <td>${book.id}</td>
                                <td>${book.name}</td>
                                <td>${book.category.name}</td>
                                <td>￥${book.price}</td>
                                <td><img src="img/g1.jpg"></td>
                                <td>
                                <a href="/updateBook?bookId=${book.id}">修改</a>
                                <a href="/deleteBook?bookId=${book.id}">删除</a>

                                </td>
                                <!--在循环显示数据时，此处的book0001可以用EL表达式进行替换-->

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="addBook.jsp"><button>新建</button></a>
                </div>
            </div>
        </section>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>
