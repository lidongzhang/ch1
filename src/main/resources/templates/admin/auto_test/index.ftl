<#include "../base/html/layout.ftl">

<#macro layout>
    <div class="layui-card">
    <div class="layui-card-header">auto_test
        <sapn class="admin-right">
            <button id="btn_add" class="layui-btn layui-btn-radius  layui-btn-xs">
                <i class="layui-icon layui-icon-add-1"></i>增加
            </button>
        </sapn>
    </div>
    <div class="layui-card-body">
        <blockquote class="layui-elem-quote">
            提示信息：如无提示信息可删除此部分内容。
        </blockquote>

        <fieldset class="layui-elem-field">
            <legend>查询条件</legend>
            <form class="layui-form" action="">
                <table>
                    
                </table>
                <div class="layui-input-block admin-text-right admin-padding-right" >
                    <button lay-submit id="search_button" lay-filter="search_button" class="layui-btn layui-btn-radius  layui-btn-xs" >
                        <i class="layui-icon layui-icon-search"></i>查询
                    </button>
                </div>
            </form>
        </fieldset>

        <fieldset class="layui-elem-field">
            <legend>查询结果</legend>
            <table id="table_select" lay-filter="table_filter"></table>
        </fieldset>
    </div>
    </div>
</#macro>

<#macro jsLayout>
    <script type="text/html" id="operate_buttons">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="view">查看</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script type="text/html" id="serialNumber">
        {{d.LAY_TABLE_INDEX+1}}
    </script>
    <script>
        var dialogViewParam = {
            open_param : {},
            close_param : {}
        };
        var dialogSaveParam = {
            open_param : {},
            close_param : {}
        };
         app.use(['ajax_table', 'table', 'jquery', 'layer', 'form', 'ajax', 'app_util'],function () {
            var ajax_table = layui.ajax_table;
            var table = layui.table;
            var $ = layui.jquery;
            var layer = layui.layer;
            var form = layui.form;
            var ajax = layui.ajax;
            var app_util = layui.app_util;

            var cols = [[
                        {title:'序号', width:60 ,fixed:true,align:'center', templet:'#serialNumber'}
                        ,{field: 'col1', title: ''}
,{field: 'col2', title: ''}
,{field: 'c1', title: ''}
,{field: 'c2', title: ''}
,{field: 'c6', title: ''}
,{field: 'c8', title: ''}
,{field: 'c10', title: ''}
,{field: 'c11', title: ''}
,{field: 'c12', title: ''}
,{field: 'c13', title: ''}
,{field: 'c14', title: ''}
,{field: 'c15', title: ''}
,{field: 'c17', title: ''}
,{field: 'c5', title: ''}
,{field: 'c18', title: 'c18'}

                        ,{fixed: 'right', width:178, align:'center', toolbar: '#operate_buttons'}
                        ]];

            form.on('submit(search_button)', function(data){
                data.field.orderBy = "id";
                ajax_table.post({
                    eleId:'#table_select',
                    url: 'auto_test/selectPageByMap',
                    id: 'ID',
                    whereJson: data.field,
                    cols:cols
                });
                return false;
            });

            table.on('tool(table_filter)', function(obj){
                var data = obj.data;
                var layEvent = obj.event;
                if(layEvent === 'del'){
                    layer.confirm('真的删除行么', function (index) {
                         layer.close(index);
                        //向服务端发送删除指令
                        ajax.post_json('auto_test/deleteByPrimaryKey', {id: data.ID}, function(d){
                            if(d.code === 'success' && d.result.code === 'success'){
                                obj.del(); //删除对应行（tr）的DOM结构 并更新缓存
                                layer.msg('删除成功!');
                                }
                            else
                                layer.msg(app_util.getErrorMsg(d));
                        });
                    });
                }
                if(layEvent === 'view'){
                    dialogViewParam.open_param.id = data.ID;
                    layer.open({
                        type: 2,
                        title: '查看数据',
                        area: ['600px', '400px'],
                        content: 'view.html'
                    });
                }
                if(layEvent === 'edit'){
                    dialogSaveParam.close_param.code = '';
                    dialogSaveParam.open_param.id = data.ID;
                    layer.open({
                        type: 2,
                        title: '添加数据',
                        area: ['600px', '400px'],
                        content: 'save.html',
                        end: function () {

                            if(dialogSaveParam.close_param.code === 'success'){
                                //$('#search_button').trigger('click');
                                var field = dialogSaveParam.close_param.field;
                                obj.update({
col1: field.col1,
col2: field.col2,
c1: field.c1,
c2: field.c2,
c6: field.c6,
c8: field.c8,
c10: field.c10,
c11: field.c11,
c12: field.c12,
c13: field.c13,
c14: field.c14,
c15: field.c15,
c17: field.c17,
c5: field.c5,
c18: field.c18});
                            }
                            $('#btn_add').removeClass('layui-btn-disabled');
                        }
                    });
                }
            });

            //btn_add click
            $('#btn_add').on('click', function () {
                $('#btn_add').addClass('layui-btn-disabled');
                dialogSaveParam.open_param.id = null;
                layer.open({
                    type: 2,
                    title: '添加数据',
                    area: ['600px', '400px'],
                    content: 'save.html',
                    end: function () {
                        if(dialogSaveParam.close_param.code === 'success')
                            $('#search_button').trigger('click');
                        $('#btn_add').removeClass('layui-btn-disabled');
                    }
                });
            });
         });
    </script>
</#macro>
