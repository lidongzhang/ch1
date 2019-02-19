layui.define(['jquery','layer', 'app_config', 'table', 'app_util'], function(exports){
    var layer = layui.layer;
    var $ = layui.jquery;
    var app_config = layui.app_config;
    var app_util = layui.app_util;
    var table = layui.table;

    var inner_table = {
        post: function(options){
            //options 内容
            //eleId 必填, url 必填, id 必填, cols 必填, whereJson, height, pageSize
            var app = layui.sessionData('app');
            if(app.user_token == null ) {
                if(url != app_config.api_url_login)
                    location.href = app_config.login_url;
            }

            var defaultOptions = {
                height: 400,
                pageSize: 20,
                page: true,
                contentType: 'application/json',
                headers: {user_token: app.user_token}
            };

            $.extend(defaultOptions, options);
            if (this.checkParam(defaultOptions) === false )
                return;


            table.render({
                elem: defaultOptions.eleId,
                height: defaultOptions.height,
                url: app_config.api_url + '/' + defaultOptions.url,
                cols: defaultOptions.cols,
                page: true,
                limit: defaultOptions.pageSize,
                id: defaultOptions.id,
                method: 'post',
                where: defaultOptions.whereJson,
                contentType: 'application/json',
                headers: {user_token: app.user_token},
                parseData: function (res) {
                    console.log(res);
                    if(res.code !== 'success')
                        return {code:100, msg:'数据获取失败!'};
                    if(res.result.code !== 'success')
                        return {code:100, msg:'数据获取失败!'};

                    return {
                        code: 0,
                        count: 200,
                        data: res.result.data
                    };
                }
            });
        },
        checkParam: function(o){

            if(app_util.isNullOrEmpty(o.eleId)) {
                layer.msg('eleId: 没有赋值');
                return false;
            }
            if(app_util.isNullOrEmpty(o.url)) {
                layer.msg('url: 没有赋值');
                return false;
            }
            if(app_util.isNullOrEmpty(o.id)) {
                layer.msg('id: 没有赋值');
                return false;
            }if(app_util.isNullOrEmpty(o.cols)) {
                layer.msg('cols: 没有赋值');
                return false;
            }

            return true;
        }
    };

    exports('ajax_table', inner_table);
});