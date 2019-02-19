<#include "../base/html/layout.ftl">

<#macro layout>
    用户信息
    <form class="layui-form "  action="" >
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
                    <button id="submit" class="layui-btn layui-btn-sm" lay-submit lay-filter="login">保存</button>
                    <button id="cancel" class="layui-btn layui-btn-sm layui-btn-primary" >取消</button>
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
        app.use(['form', 'layer', 'jquery'], function(){
            var form = layui.form;
            var layer = layui.layer;
            var $ = layui.jquery;

           layer.msg("在此可以做数据初始化处理，接收参数：" +
               parent.iframeContent1Param.open_param.id);

           form.on('submit', function(){
                $('#submit').addClass('layui-btn-disabled');
                setTimeout(function(){
                    $('#submit').removeClass('layui-btn-disabled');
                },5000);
                return false;
           });

           $('#cancel').on('click', function () {
               var index = parent.layer.getFrameIndex(window.name);
               parent.iframeContent1Param.close_param.statu = 'cancel';
               parent.layer.close(index);
           });
        });


    </script>

</#macro>