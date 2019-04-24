layui.define(['jquery','layer', 'app_config'], function(exports){
    var layer = layui.layer;
    var $ = layui.jquery;
    var app_config = layui.app_config;

    var ajax = {
        post_form: function(url, field, f){
            var contentType = 'application/x-www-form-urlencoded';
            this.post(contentType, url, field, f);
        },
        post_json: function(url, json, f){
            var contentType = 'application/json';
            var data = JSON.stringify(json);
            this.post(contentType, url, data, f);
        },
        post: function(contentType, url, data, f){

            var app = layui.sessionData('app');
            if(app.user_token == null ) {
                if(url != app_config.api_url_login)
                    location.href = app_config.login_url;
            }

            $.ajax({
                url:  app_config.api_url + '/' + url,
                type: 'post',
                dataType: 'json',
                //contentType: 'application/json',
                contentType: contentType,
                data: data,
                headers:{
                    user_token: app.user_token
                },
                async: true, //异步
                error: function(jqXHR, textStatus, errorThrown){
                        layer.msg('获取数据错误: ' + textStatus);
                    },
                success: function(data){
                    if(data.code !== 'success' ) {
                        layer.msg(data.msg);
                        if(data.msg === '没有用户身份') {
                            window.top.location.href = app_config.login_url;
                        }
                        return;
                    }
                    if(data.result.code !== 'success'){
                        layer.msg(data.result.msg);
                        if(data.result.msg === '没有用户身份') {
                            window.top.location.href = app_config.login_url;
                        }
                        return ;
                    }
                    f(data);
                }
            });
        }
    };

    exports('ajax', ajax);
});