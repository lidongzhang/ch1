layui.define(function(exports){

    var com = {
        throwError: function(msg){
            throw msg;
        },
        msgError: function(msg){
            alert(msg);
        }
    };

    exports('common', com);
});