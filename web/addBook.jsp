<%@ page import="model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String updateFlag=(String) request.getAttribute("updateFlag");
    Book book=(Book) request.getAttribute("book");
    if(book!=null){
        String id=book.getId();
        String name=book.getName();
        String categoryId=book.getCategory().getId();
        String price=book.getPrice();
        String bookPic=book.getBookPic();
        String remark=book.getDes();
    }
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>新建图书信息</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/add.css">
        <script type="application/javascript" src="js/jquery-3.4.1.js"></script>
        <script type="application/javascript">
            $(function () {
                $.ajax({
                    "url":"/selectCategory",
                    "type":"post",
                    "data":{"type":"1"},
                    "dataType":"json",
                    "success":function(json){
                        console.log(json);
                        for (var i=0;i<json.length;i++){
                            var id=json[i].id;
                            var name=json[i].name;
                            $("#categoryId").append("<option value='"
                                +id+"'>"+
                                name+"</option>");
                        }
                    }
                })
            })

            var flag='<%=updateFlag%>';
            if("1"==flag){

               //$("head>title").append("修改图书信息");
                $("head>title").text("修改图书信息");
                $("#biaoti").text("请小心地修改图书信息");
                $("#fubiaoti").text("修改");

               $("#bookId").value="b001";
               $("#bookName").val("计算机");
               $("#categoryId").val("c001");
                $("#bookPrice").val("100");
                $("#bookPic").val("1.jpg");;
                $("#remarks").val("修改备注");
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/searchBook">
                        图书信息管理
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, XXX!</h1>
                <p id="biaoti">请小心地新增图书信息，要是建了一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3 id="fubiaoti"><small>新建</small></h3>
            </div>
            <form class="form-horizontal" action="/addBook" method="post" enctype="multipart/form-data">

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">图书编号 ：</label>
                    <div class="col-sm-8">
                        <input name="bookId" class="form-control" id="bookId" value="图书id">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">图书名称 ：</label>
                    <div class="col-sm-8">
                        <input name="bookName" class="form-control" id="bookName" value="图书名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="categoryId" class="col-sm-2 control-label">分类 ：</label>
                    <select id="categoryId" name="categoryId" class="col-sm-2 form-control" style="width: auto;margin-left: 15px">
                       <!--option value="ca0001" selected="">计算机</option>
                       <option value="ca0002">文学</option-->
                       <!-- 下拉列表的内容要从分类中进行读取，value值是分类id -->
                    </select>
                </div>

                 <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">价格 ：</label>
                    <div class="col-sm-8">
                        <input name="bookPrice" class="form-control" id="bookPrice">
                    </div>
                  </div>

                  <div class="form-group" >
                    <label for="name" class="col-sm-2 control-label">图书封面 ：</label>
                    <input type="file" id="bookPic" name="bookPic" style="padding-left: 15px">
                  </div>

                  <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">备注 ：</label>
                    <div class="col-sm-8">
                        <input name="remarks" class="form-control" id="remarks">
                    </div>
                  </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@imooc
        </footer>
    </body>
</html>
