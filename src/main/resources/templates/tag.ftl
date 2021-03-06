<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>博客首页</title>
    <meta name="Keywords" Content="<%=sys.getValue("index-keyword")%>">
    <meta name="description" content="<%=sys.getValue("index-description")%>">
    <meta name="viewport" content="width=device-width">

    <#include "style.ftl">

    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
    <link rel="stylesheet" href="css/pages.css">
    <link rel="stylesheet" href="css/article.css"/>
    <link rel="stylesheet" href="css/style.css" id="theme-styles">
    <style>
        .recent-art{
            margin-top:32px;
            font-size: 14px;
        }
        .recent-art a:hover{
            color:black;
        }

        .side-art li{
            margin-top:16px;
            font-size: 12px;
        }


    </style>
</head>
<body>

<#include "./header.ftl">

<div class="widewrapper main">
    <div class="container">
        <div class="row">
            <#include "./blogMain.ftl">
           <#include "./edge.ftl">
        </div>
    </div>
</div>



<#include "./footer.ftl">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/index.js"></script>
<script src="/js/custom.js"></script>
</body>
</html>