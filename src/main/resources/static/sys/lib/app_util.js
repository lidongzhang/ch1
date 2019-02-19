layui.define(['jquery'], function (exports) {
   var $ = layui.jquery;

   var util  = function (){

    };

   util.prototype.isNullOrEmpty =function (d) {
           if (d === undefined) return false;
           if ($.trim(d) === '' ) return false;
   };


   exports('app_util', new util());
});