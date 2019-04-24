<#include "../base/html/layout.ftl">

<#macro layout>
    <div class="layui-card">
        <div class="layui-card-header">演示界面2
            <sapn class="admin-right">
                <button id="btn_add" class="layui-btn layui-btn-radius  layui-btn-xs">
                    <i class="layui-icon layui-icon-add-1"></i>增加(有问题)
                </button>
                <button id="btn_add1" class="layui-btn layui-btn-radius  layui-btn-xs">
                    <i class="layui-icon layui-icon-add-1"></i>增加-1
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
                                    <label class="layui-form-label">输入框</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">输入框</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="password" required lay-verify="required" placeholder="请输入内容" autocomplete="off" class="layui-input">
                                    </div>
                                    <div class="layui-form-mid layui-word-aux">辅助文字</div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">选择框</label>
                                    <div class="layui-input-block">
                                        <select name="city" lay-verify="required">
                                            <option value=""></option>
                                            <option value="0">北京</option>
                                            <option value="1">上海</option>
                                            <option value="2">广州</option>
                                            <option value="3">深圳</option>
                                            <option value="4">杭州</option>
                                        </select>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">复选框</label>
                                    <div class="layui-input-block">
                                        <input type="checkbox" name="like[write]" title="写作">
                                        <input type="checkbox" name="like[read]" title="阅读" checked>
                                        <input type="checkbox" name="like[dai]" title="发呆">
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">开关</label>
                                    <div class="layui-input-block">
                                        <input type="checkbox" name="switch" lay-skin="switch">
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">单选框</label>
                                    <div class="layui-input-block">
                                        <input type="radio" name="sex" value="男" title="男">
                                        <input type="radio" name="sex" value="女" title="女" checked>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <div class="layui-input-block admin-text-right admin-padding-right" >
                        <button class="layui-btn layui-btn-radius layui-btn-normal layui-btn-xs " lay-submit  lay-filter="formDemo">
                            <i class="layui-icon layui-icon-search"></i>查询
                        </button>
                     </div>
                </form>
            </fieldset>

        <fieldset class="layui-elem-field">
            <legend>查询结果</legend>
            <table id="tabl_ser" lay-filter="test"></table>
        </fieldset>
    </div>
</#macro>

<#macro jsLayout>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script>
        var iframeContent1Param = {
            open_param : {},
            close_param : {}
        };

        app.use(['ajax_table', 'table', 'jquery', 'layer'],function () {
            var ajax_table = layui.ajax_table;
            var table = layui.table;
            var $ = layui.jquery;
            var layer = layui.layer;
            ajax_table.post({
                eleId:'#tabl_ser',
                url: 'user/getUsers',
                id: 'id',
                whereJson: {a:1,b:'b'},
                cols: [[{field: 'id', title: 'id'},
                    {field: 'userName', title: 'userName'},
                    {fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}
                ]]

            });

            //监听工具条
            table.on('tool(test)', function(obj){
                var data = obj.data;
                if(obj.event === 'detail'){
                    layer.msg('ID：'+ data.id + ' 的查看操作');
                } else if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        obj.del();
                        layer.close(index);
                    });
                } else if(obj.event === 'edit'){
                    layer.alert('编辑行：<br>'+ JSON.stringify(data),
                        function(index){
                            obj.data.userName ='edited';
                            obj.update(obj.data);
                            layer.close(index);
                        }
                    );

                }
            });

            //btn_add click
            $('#btn_add').on('click', function () {
                layer.open({
                    type: 2,
                    title: '添加数据',
                    area: ['600px', '600px'],
                    content: 'iframeContent.html',
                    btn: ['保存', '取消'],
                    yes: function (index, layero) {
                        layer.msg('保存成功');
                        layer.close(index);
                    },
                    btn1: function (index) {
                        layer.close(index);
                    }
                });
            });

            //btn_add1 click
            $('#btn_add1').on('click', function () {
                $('#btn_add1').addClass('layui-btn-disabled');
                iframeContent1Param.open_param.id = 1;
                layer.open({
                    type: 2,
                    title: '添加数据-1',
                    area: ['600px', '400px'],
                    content: 'iframeContent1.html',
                    end: function () {
                        layer.msg("在此可根据返回参数做处理，返回statu: " +
                            iframeContent1Param.close_param.statu);
                        $('#btn_add1').removeClass('layui-btn-disabled');
                    }
                });
            });
        });
    </script>
</#macro>