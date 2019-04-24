<#include "../base/html/layout.ftl">

<#macro layout>
    <div class="layui-card">
    <div class="layui-card-header">T1
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
                    <tr>
                        <td>
                            <div class="layui-form-item">
                                <label class="layui-form-label">c1</label>
                                <div class="layui-input-block">
                                    <input type="text" id="c1" name="c1"  lay-verify-min="1" lay-verify-max="10" lay-verify="string"  autocomplete="off"  class="layui-input">
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="layui-form-item">
                                <label class="layui-form-label">c2</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="c2" name="c2"  lay-verify-min="1" lay-verify-max="100" lay-verify="int"  autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">辅助文字</div>
                            </div>
                        </td>
                    </tr>
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
                        {title:'序号', width:60 ,fixed:true,align:'center', templet:'#serialNumber'},
                        {field: 'ID', title: 'id'},
                        {field: 'c1', title: 'c1'},
                        {fixed: 'right', width:178, align:'center', toolbar: '#operate_buttons'}
                        ]];

            form.on('submit(search_button)', function(data){
                ajax_table.post({
                    eleId:'#table_select',
                    url: 't1/selectPageByMap',
                    id: 'ID',
                    whereJson: data.field,
                    cols:cols
                });
                return false;
            });

            table.on('tool(table_filter)', function(obj){
                var data = obj.data;
                var layEvent = obj.event;
                console.log(obj);
                if(layEvent === 'del'){
                    layer.confirm('真的删除行么', function (index) {
                         layer.close(index);
                        //向服务端发送删除指令
                        ajax.post_json('t1/deleteByPrimaryKey', {id: data.ID}, function(d){
                            console.log(d);
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
                                obj.update({c1: field.c1});
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