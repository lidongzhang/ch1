layui.define(function(exports){

    var config = {
        api_url : '/api',
        api_url_login : 'sysUser/login',
        error_url : 'error',
        login_url : '/home/admin/login.html',
        error_404_url : 'error_404',
        code_success : 'success',
        code_fail : 'fail'
    };

    exports('app_config', config);
});