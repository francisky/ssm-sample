<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/2/25
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">

    <style>
        label, input {
            display: block;
        }

        input.text {
            margin-bottom: 12px;
            width: 95%;
            padding: .4em;
        }

        fieldset {
            padding: 0;
            border: 0;
            margin-top: 25px;
        }

        div#users-contain {
            /*width: 350px;*/
            width: 85%;
            margin: 20px 0;

            /*居中*/
            margin-left: auto;
            margin-right: auto;
        }

        div#users-contain table {
            margin: 1em 0;
            border-collapse: collapse;
            width: 100%;
        }

        div#users-contain table td, div #users-contain table th {
            border: 1px solid #eee;
            padding: .6em 10px;
            text-align: left;
        }

        .ui-dialog .ui-state-error {
            padding: .3em;
        }

        .validateTips {
            border: 1px solid transparent;
            padding: 0.3em;
        }
    </style>
    <script>
        $(function () {

            $("#dialog-form").dialog({
                autoOpen: false,
                height: 600,
                width: 800,
                modal: true,
                buttons: {
                    "确认添加": function () {
                        $("#addItem").submit();
                        $(this).dialog("close");
                    },
                    取消: function () {
                        $(this).dialog("close");
                    }
                },
                close: function () {
                    allFields.val("").removeClass("ui-state-error");
                }
            });

            $("#create-user")
                .button()
                .click(function () {
                    $("#dialog-form").dialog("open");
                });
        });
    </script>
</head>
<body>

<div id="dialog-form" title="创建新用户">
    <p class="validateTips">所有的表单字段都是必填的。</p>
    <form id="addItem" action="${pageContext.request.contextPath }/addItem" method="post">
        <fieldset>
            <label for="name">商品名称</label>
            <input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all">
            <label for="price">商品价格</label>
            <input type="text" name="price" id="price" class="text ui-widget-content ui-corner-all">
            <label for="detail">商品描述</label>
            <input type="text" name="detail" id="detail" value="" class="text ui-widget-content ui-corner-all">
        </fieldset>
    </form>
</div>


<div id="users-contain" class="ui-widget">
    <div>
        <label>查询条件：</label>
        <button id="search-item" onclick="javascript:alert('hhhh')">查询</button>
        <br/>
        <button id="create-user">添加商品</button>
    </div>

    <div>
        <label>商品列表：</label>
        <table id="item-table">
            <thead>
            <tr>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>添加日期</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${itemsList }" var="item">
                <tr>
                    <td>${item.name }</td>
                    <td>${item.price }</td>
                    <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${item.detail }</td>
                    <td><a href="${pageContext.request.contextPath }/itemInfo/${item.id}">修改</a>
                        <a href="${pageContext.request.contextPath }/deleteItem/${item.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>