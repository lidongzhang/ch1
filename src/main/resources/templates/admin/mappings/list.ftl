<#include "../base/html/layout.ftl">

<#macro layout>
this is list
</#macro>

<#macro jsLayout>
    <script>
        app.use(['ajax'],function () {
            var ajax = layui.ajax;
            ajax.post_json('mappings/list', null, function(d){
                console.log(d);
            });
        });
    </script>
</#macro>