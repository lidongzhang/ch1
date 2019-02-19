<#include "base/index/indexLayout.ftl">
<#macro layout>

    <iframe class="admin-iframe"  id="right-content"
        src="home/index.html" scrolling="yes"
    ></iframe>
</#macro>

<#macro jsLayout>
    <script>
        app.use(['layer', 'ajax', 'navbar', 'jquery'],function(){
            var layer = layui.layer;
            var ajax = layui.ajax;
            var navbar = layui.navbar;
            var $ = layui.jquery;

            $(window).resize(function(){
                $('#right-content').height($(document).height() - $('#header').height()-16);
            });
            $(function(){
                $('#right-content').height($(document).height() - $('#header').height()-16);
            });

            ajax.post('menu/getMenu', null, function(data){
                console.log(data);
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