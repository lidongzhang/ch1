<#include "base/index/indexLayout.ftl">
<#macro layout>

    <iframe class="admin-iframe"  id="right-content"
        src="home/index.html" scrolling="yes"
    ></iframe>
</#macro>

<#macro jsLayout>
    <script>
        app.use(['layer', 'ajax', 'navbar', 'jquery', 'app_config', 'app'],function(){
            var layer = layui.layer;
            var ajax = layui.ajax;
            var navbar = layui.navbar;
            var $ = layui.jquery;
            var app_config = layui.app_config;
            var app = layui.app;
            console.log(app);

            $(window).resize(function(){
                $('#right-content').height($(document).height() - $('#header').height()-16);
            });
            $(function(){
                $('#right-content').height($(document).height() - $('#header').height()-16);
            });

            ajax.post_form('menu/getMenu', null, function(data){
                //console.log(data);
                if(data.code === 'fail'){
                    layer.alert(data.msg,function(index){
                        layer.close(index);
                    });
                }
                if(data.result.code === 'fail'){
                    layer.alert(data.result.msg,function(index){
                        layer.close(index);
                        if(data.result.msg === '没有用户身份')
                            window.top.location.href = app_config.login_url;
                    });
                }

                navbar.set({
                    elem: '#nav',
                    data: data.result.data

                });
                navbar.render();
                navbar.on('click(demo)', function(data) {
                    //layer.msg(data.field.href);
                    $('#right-content').attr("src", data.field.href);
                });
            });
            //layer.msg('hello');
        });
    </script>
</#macro>