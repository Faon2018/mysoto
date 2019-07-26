<#include "base/base.ftl">
<@body>
    登录成功！
    <p>欢迎${user.getUsername()}先生/女士</p>
    <a href="https://github.com/login/oauth/authorize?client_id=bb97988ddf5206af5fff&redirect_uri=http://localhost:8081/callback&scope=user&state=1">登录</a>
</@body>