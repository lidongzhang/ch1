<#include "../base/html/layout.ftl">

<#macro layout>
    <div class="layui-card">
        <div class="layui-card-header">演示界面1</div>
        <div class="layui-card-body">
            <fieldset class="layui-elem-field">
                <legend>数据信息</legend>
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
                            <td><div class="layui-form-item">
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
                                </div></td>
                            <td><div class="layui-form-item">
                                    <label class="layui-form-label">复选框</label>
                                    <div class="layui-input-block">
                                        <input type="checkbox" name="like[write]" title="写作">
                                        <input type="checkbox" name="like[read]" title="阅读" checked>
                                        <input type="checkbox" name="like[dai]" title="发呆">
                                    </div>
                                </div></td>
                        </tr>
                        <tr>
                            <td><div class="layui-form-item">
                                    <label class="layui-form-label">开关</label>
                                    <div class="layui-input-block">
                                        <input type="checkbox" name="switch" lay-skin="switch">
                                    </div>
                                </div></td>
                            <td><div class="layui-form-item">
                                    <label class="layui-form-label">单选框</label>
                                    <div class="layui-input-block">
                                        <input type="radio" name="sex" value="男" title="男">
                                        <input type="radio" name="sex" value="女" title="女" checked>
                                    </div>
                                </div></td>
                        </tr>
                    </table>
                    </div>

                    <button type="button" class="layui-btn" id="test1">
                        <i class="layui-icon">&#xe67c;</i>上传文件
                    </button>

                    <div class="layui-form-item " >
                        <div class="layui-input-block" >
                            <button class="layui-btn layui-btn-normal layui-btn-xs " lay-submit  lay-filter="formDemo">
                                <i class="layui-icon layui-icon-edit"></i>保存
                            </button>
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>
    </div>
</#macro>

<#macro jsLayout>
    <script>
        app.use(['form', 'upload', 'ajax'], function () {
           var form = layui.form;
           var upload = layui.upload;
           var ajax = layui.ajax;

           upload.render({
                elem: '#test1' //绑定元素
                ,url: '/upload/file' //上传接口
                ,accept: 'file'
                ,data:{user_token: '123456'}
                ,done: function(res){
                    //上传完毕回调
                   console.log(res);
                }
                ,error: function(){
                    //请求异常回调
                   layer.msg('上传失败');
                }
            });




        });
    </script>
</#macro>