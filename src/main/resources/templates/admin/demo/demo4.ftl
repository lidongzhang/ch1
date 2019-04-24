<#include  "../base/html/layout.ftl">

<#macro layout>
    <div class="layui-card">
    <div class="layui-card-header">演示界面1</div>
    <div class="layui-card-body">

        <button id="mybatis" class="layui-btn layui-btn-normal layui-btn-xs " >
            <i class="layui-icon layui-icon-edit"></i>mybatis
        </button>

        <button id="mybatisSave" class="layui-btn layui-btn-normal layui-btn-xs " >
            <i class="layui-icon layui-icon-edit"></i>mybatisSave
        </button>

        <button id="mybatisSaveChange" class="layui-btn layui-btn-normal layui-btn-xs " >
            <i class="layui-icon layui-icon-edit"></i>mybatisSaveChange
        </button>

        <button id="mybatisSelectByPage" class="layui-btn layui-btn-normal layui-btn-xs " >
            <i class="layui-icon layui-icon-edit"></i>mybatisSelectByPage
        </button>

        <button id="redis" class="layui-btn layui-btn-normal layui-btn-xs " >
            <i class="layui-icon layui-icon-edit"></i>redis
        </button>

        <button id="userSave" class="layui-btn layui-btn-normal layui-btn-xs " >
            <i class="layui-icon layui-icon-edit"></i>user/save
        </button>

        <button id="download" class="layui-btn layui-btn-normal layui-btn-xs " >
            <i class="layui-icon layui-icon-edit"></i>download/file
        </button>

        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">输入框</label>
                <div class="layui-input-block">
                    <input type="text" name="title"  lay-verify-min="5"  lay-verify="test" placeholder="请输入标题" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item " >
                <div class="layui-input-block" >
                    <button class="layui-btn layui-btn-normal layui-btn-xs " lay-submit  lay-filter="formDemo">
                        <i class="layui-icon layui-icon-edit"></i>保存
                    </button>
                </div>
            </div>
        </form>
    </div>
    </div>
    </div>
</#macro>

<#macro jsLayout>
    <script>
        app.use(['ajax', 'element', 'jquery', 'layer', 'form'], function(){
            var element = layui.element;
            var $ = layui.jquery;
            var layer = layui.layer;
            var ajax = layui.ajax;
            var form = layui.form;
            form.on('submit', function(){
                layer.msg("a");
                return false;
            });

            $('#mybatis').on('click',function(){
               layer.msg('mybatis');
               ajax.post_form('t1Test/getT1', null, function(d){
                   console.log(d);
               });
            });

            $('#mybatisSave').on('click', function(){
               layer.msg('mybatisSave');
               ajax.post_form('t1Test/save', null, function(d){
                   console.log(d);
               });
            });

            $('#mybatisSaveChange').on('click', function(){
                layer.msg('mybatisSaveChange');
                ajax.post_form('t1Test/saveChange', null, function(d){
                    console.log(d);
                });
            });

            //mybatisSelectByPage
            $('#mybatisSelectByPage').on('click', function(){
                layer.msg('mybatisSelectByPage');
                ajax.post_form('t1Test/selectByPage', null, function(d){
                    console.log(d);
                });
            });

            $('#redis').on('click', function(){
               layer.msg('redis');
                ajax.post_form('redis/test', null, function (d) {
                    console.log(d);
                });
            });

            $('#userSave').on('click', function(){
               layer.msg('user save');
               ajax.post_form('user/save', {
                   id:1,
                   userName:'姓名',
                   birthday: '2019-1-1',
                   score: 1.02
               } , function(d){
                  console.log(d);
               });
            });

            $('#download').on('click', function(){
                // layer.msg('download');
                // ajax.post('download/file', {
                //     fileName : 'test/1.txt'
                // } , function(d){
                //     console.log(d);
                // });

                var url = '../../../api/download/file';
                var fileName = 'test/1.txt';
                var form = $("<form></form>").attr("action", url).attr("method", "post");
                form.append($("<input></input>").attr("type", "hidden").attr("name", "fileName").attr("value", fileName));
                var user_token = '123456';
                form.append($("<input></input>").attr("type", "hidden").attr("name", "user_token").attr("value", user_token));
                form.appendTo('body').submit().remove();
            });

        });
    </script>

</#macro>