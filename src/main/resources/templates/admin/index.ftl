<#include "base/index/indexLayout.ftl">
<#macro layout>

    <iframe class="admin-iframe"></iframe>
</#macro>

<#macro jsLayout>
    <script>
        app.use('layer',function(){
            var layer = layui.layer;

            layer.msg('hello');
        });
    </script>
</#macro>