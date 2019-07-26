<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!--标题-->
    <#macro title>
    <#nested>
    </#macro>
    <!--css-->
    <#macro css>
    <#nested>
    </#macro>
    <link rel="stylesheet" href="/css/bootstrap.min.css" media="all">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css" media="all">
</head>
<body>

    <#macro body>
    <#nested>
    </#macro>
    <!--js-->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/vue.js"></script>
    <script src="/node_modules/axios/axios.js"></script>
    <#macro js>
    <#nested>
    </#macro>
</body>
</html>
