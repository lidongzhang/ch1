<#include "../base/html/layout.ftl">

<#macro layout>
    <div class="layui-card">
        <div class="layui-card-header">演示界面1
            <sapn class="admin-right">
                <button class="layui-btn layui-btn-radius  layui-btn-xs">
                    <i class="layui-icon layui-icon-add-1"></i>增加
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-warm layui-btn-xs">
                    <i class="layui-icon layui-icon-edit"></i>修改
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-danger layui-btn-xs">
                    <i class="layui-icon layui-icon-delete"></i>删除
                </button>
                <button class="layui-btn layui-btn-radius layui-btn-normal layui-btn-xs">
                    <i class="layui-icon layui-icon-search"></i>查询
                </button>
            </sapn>
            </sapn>
        </div>
        <div class="layui-card-body">
            <blockquote class="layui-elem-quote">
                提示信息：abcd。
            </blockquote>

            <fieldset class="layui-elem-field">
                <legend>人员信息</legend>
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">输入框</label>
                        <div class="layui-input-block">
                            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码框</label>
                        <div class="layui-input-inline">
                            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">辅助文字</div>
                    </div>
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
                    <div class="layui-form-item">
                        <label class="layui-form-label">复选框</label>
                        <div class="layui-input-block">
                            <input type="checkbox" name="like[write]" title="写作">
                            <input type="checkbox" name="like[read]" title="阅读" checked>
                            <input type="checkbox" name="like[dai]" title="发呆">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">开关</label>
                        <div class="layui-input-block">
                            <input type="checkbox" name="switch" lay-skin="switch">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">单选框</label>
                        <div class="layui-input-block">
                            <input type="radio" name="sex" value="男" title="男">
                            <input type="radio" name="sex" value="女" title="女" checked>
                        </div>
                    </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">文本域</label>
                        <div class="layui-input-block">
                            <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn layui-btn-sm" lay-submit  lay-filter="formDemo">
                                <i class="layui-icon layui-icon-edit"></i>保存
                            </button>
                            <button type="reset" class="layui-btn layui-btn-sm layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </fieldset>
        </div>
    </div>
</#macro>

<#macro jsLayout>
    <script>
        app.use(['form'], function(){
            var from = layui.form;
        });
    </script>
</#macro>