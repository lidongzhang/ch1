<script src="${app.base_sys_url}/layui/layui.js?version=${app.layui_version}"></script>
<script>

   var app = layui.config({
        version:true,
        v: '${app.version}',
        base: ['${app.base_sys_url}/']
    }).extend({
        app_config: 'lib/app_config',
        app: 'lib/app',
        app_util: 'lib/app_util',
        ajax_table: 'lib/ajax_table',
        ajax: 'lib/ajax',
        navbar: 'modules/navbar',
        common: 'lib/common'
    }).use(['app_config','app_util', 'app'],function(){
        var app_config = layui.app_config;
        var app_util = layui.app_util;
        var app = layui.app;

        //检查用户身份，没有则跳转
       if(location.href.indexOf(app_config.login_url) < 0 ) {
           var sapp = layui.sessionData('app');
           app.setUser(sapp);
           if (sapp.user_token == null) {
               //location.href = app_config.login_url;
               //顶级窗口跳转登录页面
               window.top.location.href = app_config.login_url;
           }
       }
   }).use(['form', 'jquery', 'layer'], function(){
       var form = layui.form;
       var $ = layui.jquery;
       var layer = layui.layer;

       form.verify({
            string: function(value, item) {
                var l = value.length;
                if(l === 0) return;
                var min = $(item).attr('lay-verify-min');
                var max = $(item).attr('lay-verify-max');
                if(l < min || l > max)
                    return '内容长度请控制在: ' + min + '个字符到' + max + '个字符之间。';
            },
            int: function(value, item){
                if(value.length === 0) return;
                //console.log(typeof value);
                var v = Number(value);
                if(!(Math.floor(v) === v))
                    return "请输入整数！";
                var min = Number($(item).attr('lay-verify-min'));
                var max = Number($(item).attr('lay-verify-max'));
                if(v < min || v > max)
                    return '整数请不要小于: ' + min + '大于' + max + '。';
            },
           decimal: function(value, item){
               if(value.length === 0) return;
               var v = Number(value);
               if(isNaN(v))
                   return "请输入小数！";
               var s = v.toString();
               var min = Number($(item).attr('lay-verify-min'));
               var max = Number($(item).attr('lay-verify-max'));
               if(v < min || v > max)
                   return '数据请不要小于: ' + min + '大于' + max + '。';
               if(s.indexOf(".") === -1) return ;
               var precision = Number($(item).attr('lay-verify-precision'));
               var i = s.indexOf(".");
               var n = s.length;
               if (n - i - 1 > precision)
                   return '数据小数位数不能大于' + precision;
           },
           date: function(data, item){
               if(data.length === 0) return;
               if(isNaN(data)&&!isNaN(Date.parse(data))){
                   return;
               }
               return "请输入日期格式：yyyy-MM-dd";
           },
           datetime: function(data, item){
               if(data.length === 0) return;
               if(isNaN(data)&&!isNaN(Date.parse(data))){
                   return;
               }
               return "请输入时间格式：yyyy-MM-dd hh:mm:ss";
           },
           time: function(data, item){
                return;
               if(data.length === 0) return;
               if(isNaN(data)&&!isNaN(Date.parse( '00:00:00 ' + data))){
                   return;
               }
               return "请输入时间格式：hh:mm:ss";
           }
       });

   });

</script>