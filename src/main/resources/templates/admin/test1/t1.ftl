<#include "../base/html/layout.ftl">
<#macro layout>
 this is t1.layout
</#macro>

<#macro jsLayout>
<script>
    app.use(['layer','app_config','ajax'],function(){
        var layer = layui.layer;
        var config = layui.app_config;
        var ajax = layui.ajax;
        ajax.post('hello/sayHello', null, function(result){
            console.log(result);
            layer.msg(result.data.data);
        });

    });
</script>
</#macro>