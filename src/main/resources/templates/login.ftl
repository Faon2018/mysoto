<#include "base/base.ftl">
    <@title>
        <title>登录页面</title>
    </@title>
    <@css>
        <style>
            .login{
                margin-top: 200px;
            }
        </style>
    </@css>
<@body>
    <div class="container-fluid">
        <div class="login">
            <form class="form-horizontal col-sm-offset-3" action="/login">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="username" placeholder="用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" name="password" placeholder="密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Remember me
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</@body>