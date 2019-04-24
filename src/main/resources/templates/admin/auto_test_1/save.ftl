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
                        <label class="admin-form-label" >c1</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c1" name="c1"  lay-verify-min="0" lay-verify-max="10" lay-verify="string"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c2</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c2" name="c2"  lay-verify-min="-2147483648" lay-verify-max="2147483647" lay-verify="int"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c3</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c3" name="c3"  lay-verify-min="0" lay-verify-max="50" lay-verify="string"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c4</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c4" name="c4"  lay-verify-min="" lay-verify-max="" lay-verify="date"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c5</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c5" name="c5"  lay-verify-min="" lay-verify-max="" lay-verify="time"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c6</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c6" name="c6"  lay-verify-min="" lay-verify-max="" lay-verify="datetime"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c7</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c7" name="c7"  lay-verify-min="-9999999999999999" lay-verify-max="9999999999999999" lay-verify="decimal"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c8</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c8" name="c8"  lay-verify-min="0" lay-verify-max="1073741823" lay-verify="string"  autocomplete="off" class="layui-input">
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

            laydate.render({
                elem: '#c4', type:'date',trigger: 'click'
            });
laydate.render({
                elem: '#c5', type:'time',trigger: 'click'
            });
laydate.render({
                elem: '#c6', type:'datetime',trigger: 'click'
            });


            var url = '';
            var id = parent.dialogSaveParam.open_param.id;
            if(id === undefined || id == null ){
                url = 'auto_test_1/insertChanged';
            }else{
                url = 'auto_test_1/updateByPrimaryKeyChanged';
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
            ajax.post_json('auto_test_1/getByPrimaryKey', {id:id}, function(d){
                layer.close(index);
                if(d.code === 'fail'){
                    layer.msg("获取信息错误:" + d.msg);
                    return;
                }
                if(d.result.code === 'fail'){
                    layer.msg('获取信息错误:' + d.result.msg);
                    return;
                }

                $('#c1').val(d.result.data.c1 || '');
$('#c2').val(d.result.data.c2 || '');
$('#c3').val(d.result.data.c3 || '');
$('#c4').val(d.result.data.c4 || '');
$('#c5').val(d.result.data.c5 || '');
$('#c6').val(d.result.data.c6 || '');
$('#c7').val(d.result.data.c7 || '');
$('#c8').val(d.result.data.c8 || '');


            });

        }
    </script>
</#macro>
