<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <#include "../html/css.ftl">
</head>
<body class="layui-layout-body">
<div class="admin-container">
    <#include "header.ftl">
    <div>
        <#include "menu.ftl">
        <div class="admin-section">
            <@layout></@layout>
        </div>
    </div>


    <#include "footer.ftl">
</div>
<#include "../html/js.ftl">
<@jsLayout></@jsLayout>
</body>
</html>