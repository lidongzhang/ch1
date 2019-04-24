layui.define(function(exports){

    var app = {
        user: null,
        setUser: function(u){
            this.user = u;
        }
    };

    exports('app', app);
});