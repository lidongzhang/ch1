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
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="col1" name="col1"  lay-verify-min="0" lay-verify-max="50" lay-verify="string"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="col2" name="col2"  lay-verify-min="-2147483648" lay-verify-max="2147483647" lay-verify="int"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c1" name="c1"  lay-verify-min="0" lay-verify-max="50" lay-verify="string"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c2" name="c2"  lay-verify-min="-9223372036854775808" lay-verify-max="9223372036854775807" lay-verify="int"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c6" name="c6"  lay-verify-min="-999999999999999" lay-verify-max="999999999999999" lay-verify="decimal"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c8" name="c8"  lay-verify-min="0" lay-verify-max="10" lay-verify="string"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c10" name="c10"  lay-verify-min="" lay-verify-max="" lay-verify="date"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c11" name="c11"  lay-verify-min="" lay-verify-max="" lay-verify="time"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c12" name="c12"  lay-verify-min="" lay-verify-max="" lay-verify="datetime"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c13" name="c13"  lay-verify-min="" lay-verify-max="" lay-verify="datetime"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c14" name="c14"  lay-verify-min="-32768" lay-verify-max="32767" lay-verify="int"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c15" name="c15"  lay-verify-min="-128" lay-verify-max="127" lay-verify="int"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c17" name="c17"  lay-verify-min="0" lay-verify-max="10" lay-verify="string"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c5" name="c5"  lay-verify-min="0" lay-verify-max="1073741823" lay-verify="string"  autocomplete="off" class="layui-input">
                        </div>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c18</label>
                    </td>
                    <td >
                        <div class="layui-input-inline">
                            <input type="text" id="c18" name="c18"  lay-verify-min="-9999999999999999" lay-verify-max="9999999999999999" lay-verify="decimal"  autocomplete="off" class="layui-input">
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
                elem: '#c10', type:'date',trigger: 'click'
            });
laydate.render({
                elem: '#c11', type:'time',trigger: 'click'
            });
laydate.render({
                elem: '#c12', type:'datetime',trigger: 'click'
            });
laydate.render({
                elem: '#c13', type:'datetime',trigger: 'click'
            });


            var url = '';
            var id = parent.dialogSaveParam.open_param.id;
            if(id === undefined || id == null ){
                url = 'auto_test/insertChanged';
            }else{
                url = 'auto_test/updateByPrimaryKeyChanged';
                load(id, ajax, $, layer);
            }

            form.on('submit(btnSave)', function(data){
                $('#btnSave').addClass('layui-btn-disabled');
                var index = layer.load();
                data.field.ID = id;
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
            ajax.post_json('auto_test/getByPrimaryKey', {id:id}, function(d){
                layer.close(index);
                if(d.code === 'fail'){
                    layer.msg("获取信息错误:" + d.msg);
                    return;
                }
                if(d.result.code === 'fail'){
                    layer.msg('获取信息错误:' + d.result.msg);
                    return;
                }

                $('#col1').val(d.result.data.col1 || '');
$('#col2').val(d.result.data.col2 || '');
$('#c1').val(d.result.data.c1 || '');
$('#c2').val(d.result.data.c2 || '');
$('#c6').val(d.result.data.c6 || '');
$('#c8').val(d.result.data.c8 || '');
$('#c10').val(d.result.data.c10 || '');
$('#c11').val(d.result.data.c11 || '');
$('#c12').val(d.result.data.c12 || '');
$('#c13').val(d.result.data.c13 || '');
$('#c14').val(d.result.data.c14 || '');
$('#c15').val(d.result.data.c15 || '');
$('#c17').val(d.result.data.c17 || '');
$('#c5').val(d.result.data.c5 || '');
$('#c18').val(d.result.data.c18 || '');


            });

        }
    </script>
</#macro>
