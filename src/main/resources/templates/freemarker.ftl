<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center>
    <p>
        welcome ${name} to ${sex}  ${test}  freemarker!
    </p>

    <p>性别：
        <#if sex==0>
        女
        <#elseif sex==1>
        男
        <#else>
        保密
    </#if>
    </p>

    <h4>我的好友：</h4>
    <#list friends as item>
    姓名：${item.name} , 年龄${item.age}
    <br>
    </#list>
</center>

</body>
</html>