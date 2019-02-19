<#include "base/html/layout.ftl" >
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
</#macro>

<#macro jsLayout>
    <script>
        app.use(['form', 'ajax', 'layer'], function(){
            var form = layui.form;
            var ajax = layui.ajax;
            var layer = layui.layer;
            var app_config = layui.app_config;
            //监听提交
            form.on('submit(login)', function(data){
                ajax.post('user/login', data.field, function(d){
                    console.log(d);
                    if (d.code == app_config.code_success
                        && d.result.code == app_config.code_success){
                        layui.sessionData('app',{key:'user_token', value: d.result.data.token});
                        location.href = 'index.html';
                    }else{
                        layer.msg('登陆失败！');
                    }
                });
                return false;
            });
        });
    </script>
</#macro>


