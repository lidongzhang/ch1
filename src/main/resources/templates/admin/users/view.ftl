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
                        <label class="admin-form-label" >昵称</label>
                    </td>
                    <td >
                        <label id="nick_name" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >密码</label>
                    </td>
                    <td >
                        <label id="password" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >名字</label>
                    </td>
                    <td >
                        <label id="name" class="admin-form-content"></label>
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
        ajax.post_json('users/getByPrimaryKey', {id:id}, function(d){
            layer.close(index);
            if(d.code === 'fail'){
                layer.msg("获取信息错误:" + d.msg);
                return;
            }
            if(d.result.code === 'fail'){
                layer.msg('获取信息错误:' + d.result.msg);
                return;
            }
            $('#nick_name').text(d.result.data.nick_name || '');
$('#password').text(d.result.data.password || '');
$('#name').text(d.result.data.name || '');



        });

    }
    </script>
</#macro>
