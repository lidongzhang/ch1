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
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="col1" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="col2" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c1" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c2" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c6" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c8" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c10" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c11" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c12" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c13" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c14" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c15" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c17" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" ></label>
                    </td>
                    <td >
                        <label id="c5" class="admin-form-content"></label>
                    </td>
                </tr>
<tr>
                    <td style="width:50px;">
                        <label class="admin-form-label" >c18</label>
                    </td>
                    <td >
                        <label id="c18" class="admin-form-content"></label>
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
            $('#col1').text(d.result.data.col1 || '');
$('#col2').text(d.result.data.col2 || '');
$('#c1').text(d.result.data.c1 || '');
$('#c2').text(d.result.data.c2 || '');
$('#c6').text(d.result.data.c6 || '');
$('#c8').text(d.result.data.c8 || '');
$('#c10').text(d.result.data.c10 || '');
$('#c11').text(d.result.data.c11 || '');
$('#c12').text(d.result.data.c12 || '');
$('#c13').text(d.result.data.c13 || '');
$('#c14').text(d.result.data.c14 || '');
$('#c15').text(d.result.data.c15 || '');
$('#c17').text(d.result.data.c17 || '');
$('#c5').text(d.result.data.c5 || '');
$('#c18').text(d.result.data.c18 || '');



        });

    }
    </script>
</#macro>
