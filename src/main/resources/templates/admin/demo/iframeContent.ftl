<#include "../base/html/layout.ftl">

<#macro layout>
    <form class="layui-form admin-user-login"  action="" >
        <div >
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="text" name="nickName" required  lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">

                <div class="layui-input-inline">
                    <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6位以上包含数字和大小写字母</div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="login">登陆</button>
                </div>
            </div>
        </div>
    </form>

    1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>
    1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>
    1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>
    1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>2<br>

</#macro>

<#macro jsLayout>
    <script>
        app.use(['form', 'layer'], function(){
            var form = layui.form;
            var layer = layui.layer;

           layui.onevent('form', 'submit', function(){
                layer.msg('submit event');
           });

           form.submit();
        });
    </script>

</#macro>