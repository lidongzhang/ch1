layui.define(['jquery','layer', 'app_config'], function(exports){
    var layer = layui.layer;
    var $ = layui.jquery;
    var app_config = layui.app_config;

    var ajax = {
        post: function(url, json, f){

            var app = layui.sessionData('app');
            if(app.user_token == null ) {
                if(url != app_config.api_url_login)
                    location.href = app_config.login_url;
            }

            $.ajax({
                url:  app_config.api_url + '/' + url,
                type: 'post',
                dataType: 'json',
                data: json,
                headers:{
                    user_token: app.user_token
                },
                async: true, //异步
                error: function(jqXHR, textStatus, errorThrown){
                        layer.msg('获取数据错误: ' + textStatus);
                    },
                success: function(data){ f(data); }
            });
        }
    };

    exports('ajax', ajax);
});