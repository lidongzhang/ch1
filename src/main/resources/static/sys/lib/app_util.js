layui.define(['jquery'], function (exports) {
   var $ = layui.jquery;

   var util  = function (){

    };

   util.prototype.isNullOrEmpty = function (d) {
       if (d === undefined) return false;
       if ($.trim(d) === '' ) return false;
   };

   util.prototype.getErrorMsg =  function(d) {
       if (d.code !== 'success') {
           return d.msg;
       }
       if (d.result.code !== 'success') {
           return d.result.msg;
       }
       return null;
   };

   exports('app_util', new util());
});