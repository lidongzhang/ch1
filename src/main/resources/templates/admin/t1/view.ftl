<#include "../base/html/layout.ftl">

<#macro layout>
    <div class="layui-card">
        <div class="layui-card-body">
            <blockquote class="layui-elem-quote">
                提示信息：如无提示信息可删除此部分内容。
            </blockquote>
            <table class="layui-table">
                <tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c1</label>
                    </td>
                    <td >
                        <label id="c1" class="admin-form-content"></label>
                    </td>
                </tr>
                <tr>
                    <td >
                        <label class="admin-form-label" >c2</label>
                    </td>
                    <td >
                        <label id="c2" class="admin-form-content"></label>
                    </td>
                </tr>
                <tr>
                    <td >
                        <label class="admin-form-label" >c3</label>
                    </td>
                    <td >
                        <label id="c3" class="admin-form-content"></label>
                    </td>
                </tr>
                <tr>
                    <td >
                        <label class="admin-form-label" >c4</label>
                    </td>
                    <td >
                        <label id="c4" class="admin-form-content"></label>
                    </td>
                </tr>
                <tr>
                    <td >
                        <label class="admin-form-label" >c5</label>
                    </td>
                    <td >
                        <label id="c5" class="admin-form-content"></label>
                    </td>
                </tr>
                <tr>
                    <td >
                        <label class="admin-form-label" >c6</label>
                    </td>
                    <td >
                        <label id="c6" class="admin-form-content"></label>
                    </td>
                </tr>
                <tr>
                    <td >
                        <label class="admin-form-label" >c7</label>
                    </td>
                    <td >
                        <label id="c7" class="admin-form-content"></label>
                    </td>
                </tr>
            </table>
            <div class="admin-text-right admin-padding-right" >
                <button id="btnClose" class="layui-btn layui-btn-radius  layui-btn-xs" >
                    <i class="layui-icon layui-icon-close"></i>关闭
                </button>
            </div>
        </div>
    </div>
</#macro>

<#macro jsLayout>
    <script>
    app.use(['ajax', 'jquery', 'layer'],function(){
       var ajax = layui.ajax;
       var $ = layui.jquery;
       var layer = layui.layer;
       load(parent.dialogViewParam.open_param.id, ajax, $, layer);

        $('#btnClose').on('click', function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });
    });

    function load(id, ajax, $, layer){
        var index = layer.load();
        ajax.post_json('t1/getByPrimaryKey', {id:id}, function(d){
            layer.close(index);
            //console.log(d);
            if(d.code === 'fail'){
                layer.msg("获取信息错误:" + d.msg);
                return;
            }
            if(d.result.code === 'fail'){
                layer.msg('获取信息错误:' + d.result.msg);
                return;
            }
            $('#c1').text(d.result.data.c1 || '');
            $('#c2').text(d.result.data.c2 || '');
            $('#c3').text(d.result.data.c3 || '');
            $('#c4').text(d.result.data.c4 || '');
            $('#c5').text(d.result.data.c5 || '');
            $('#c6').text(d.result.data.c6 || '');
            $('#c7').text(d.result.data.c7 || '');

        });

    }
    </script>
</#macro>