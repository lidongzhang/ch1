<#include "../base/html/layout.ftl">

<#macro layout>
    <div class="layui-card">
        <div class="layui-card-body">
            <blockquote class="layui-elem-quote">
                提示信息：如无提示信息可删除此部分内容。
            </blockquote>
            <form class="layui-form" action="">
            <table class="layui-table">
                <tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >名称</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="name" name="name"  lay-verify-min="0" lay-verify-max="200" lay-verify="required|string"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>

            </table>
            <div class="admin-text-right admin-padding-right" >
                <button id="btnSave" lay-submit  class="layui-btn layui-btn-xs" lay-filter="btnSave" >
                    <i class="layui-icon layui-icon-ok"></i>保存
                </button>
                <button id="btnClose" type="button" class="layui-btn layui-btn-primary  layui-btn-xs" >
                    <i class="layui-icon layui-icon-close"></i>关闭
                </button>
            </div>
            </form>
        </div>
    </div>
</#macro>

<#macro jsLayout>
    <script>
        app.use(['ajax', 'jquery', 'layer', 'form', 'laydate'],function(){
            var ajax = layui.ajax;
            var $ = layui.jquery;
            var layer = layui.layer;
            var form = layui.form;
            var laydate = layui.laydate;

            

            var url = '';
            var id = parent.dialogSaveParam.open_param.id;
            if(id === undefined || id == null ){
                url = 'sys_right_group/insertChanged';
            }else{
                url = 'sys_right_group/updateByPrimaryKeyChanged';
                load(id, ajax, $, layer);
            }

            form.on('submit(btnSave)', function(data){
                $('#btnSave').addClass('layui-btn-disabled');
                var index = layer.load();
                data.field.id = id;
                ajax.post_json(url, data.field, function(d){
                    layer.close(index);
                    if(d.code === 'fail'){
                        layer.msg("获取信息错误:" + d.msg);
                        return false;
                    }
                    if(d.result.code === 'fail'){
                        layer.msg('获取信息错误:' + d.result.msg);
                        return false;
                    }
                    layer.alert("保存成功！", function () {
                        parent.dialogSaveParam.close_param.code = 'success';
                        parent.dialogSaveParam.close_param.field = data.field;
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    });
                });
                return false;
            });

            $('#btnClose').on('click', function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        });

        function load(id, ajax, $, layer){
            var index = layer.load();
            ajax.post_json('sys_right_group/getByPrimaryKey', {id:id}, function(d){
                layer.close(index);
                if(d.code === 'fail'){
                    layer.msg("获取信息错误:" + d.msg);
                    return;
                }
                if(d.result.code === 'fail'){
                    layer.msg('获取信息错误:' + d.result.msg);
                    return;
                }

                $('#name').val(d.result.data.name || '');


            });

        }
    </script>
</#macro>
