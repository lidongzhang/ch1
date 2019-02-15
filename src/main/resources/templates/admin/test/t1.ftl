<#include "../base/html/layout.ftl">
<#macro layout>
 this is t1.layout
</#macro>

<#macro jsLayout>
<script>
    app.use('layer',function(){
        var layer = layui.layer;

        layer.msg('hello');
    });
</script>
</#macro>