<script src="${app.base_sys_url}/layui/layui.js"></script>
<script>

   var app = layui.config({
        base: ['${app.base_sys_url}/']
    }).extend({
        app_config: 'lib/app_config',
        app_util: 'lib/app_util',
        ajax_table: 'lib/ajax_table',
        ajax: 'lib/ajax',
        navbar: 'modules/navbar',
        common: 'lib/common'
    }).use('app_config',function(){
        var app_config = layui.app_config;

        app_config.api_url = '/api';
        app_config.api_url_login = 'user/login'
        app_config.error_url = 'error';
        app_config.login_url = '/home/admin/login.html';
        app_config.error_404_url = 'error_404';
        app_config.code_success = 'success';
        app_config.code_fail = 'fail';

        //检查用户身份，没有则跳转
       if(location.href.indexOf(app_config.login_url) < 0 ) {
           var app = layui.sessionData('app');
           if (app.user_token == null) {
               location.href = app_config.login_url;
           }
       }
   });

</script>