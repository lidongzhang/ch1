<#include "../base/html/layout.ftl">

<#macro layout>
<div class="layui-card">
    <div class="layui-card-header">基础权限设置

    </div>
    <form class="layui-form" action="">
        <div id="right" style="margin-left:10px;">

        </div>
    </form>
</div>
</#macro>

<#macro jsLayout>
    <script id="rightTmp" type="text/html">
        <ul>
        {{#  layui.each(d, function(index, item){ }}

            <li style="margin-bottom: 10px;" data='{"id": {{item.id}}, "memo": "{{=item.memo}}", "matchUrl": "{{=item.matchUrl}}", "domain": "{{=item.domain}}", "model": "{{=item.model}}"  }' >
                <i   class="layui-icon layui-icon-template-1 admin-color-green admin-text-bold " title="controller"  ></i>
                <span id="memo">[{{=item.memo}} ]</span>  <i event="editControllerMemo"  class="admin-hand layui-icon layui-icon-edit admin-color-green admin-text-bold " title="修改功能说明"  ></i>

                {{ item.name }}
                <span id="matchUrl">{ {{=item.matchUrl}} }</span> <i event="editControllerMatchUrl" class="admin-hand layui-icon layui-icon-edit admin-color-green admin-text-bold "  title="修改菜单栏匹配地址" ></i>

                {{# /* up */ }}
                <i event="sortControllerUp" class="admin-hand layui-icon layui-icon-up admin-color-green"  style="font-weight: bolder;"  title="向上移动" ></i>

                {{# /* down */ }}
                <i event="sortControllerDown" class="admin-hand layui-icon layui-icon-down admin-color-green" style="font-weight: bolder;"  title="向下移动"  ></i>

                {{# if(!item.sysHas) { }}
                     <i class="layui-icon layui-icon-about admin-color-red admin-text-bold " title="数据库有存储，但系统中已经没有了！"   ></i>
                     <i event="delController" class="admin-hand layui-icon layui-icon-close-fill admin-color-yellow admin-text-bold " title="删除"  ></i>
                {{# } }}

                <span id="domain">[{{=item.domainDisplayName}}]</span>
                <i event="editControllerDomain"  class="admin-hand layui-icon layui-icon-edit admin-color-green admin-text-bold " title="修改功能域"  ></i>

                {{# if(item.model === 'EVERYONE' ) { }}
                    <i event="modelController"  id="model" class="admin-hand layui-icon layui-icon-group admin-color-green admin-text-bold " title="本域内所有人都可访问"  ></i>
                {{# } }}

                {{# if(item.model === 'ASSIGN' ) { }}
                    <i event="modelController"  id="model" class="admin-hand layui-icon layui-icon-friends admin-color-green admin-text-bold " title="本域内指定人员可访问"  ></i>
                {{# } }}

                <ul style="margin-left:20px;">
                {{# layui.each(item.methods, function(index, method){ }}
                    <li data='{"id": {{method.id}}, "memo": "{{=method.memo}}" }'>
                        <i   class="layui-icon layui-icon-senior admin-color-green admin-text-bold "   ></i>
                        <span id="methodMemo">[{{=method.memo}}]</span>
                        <i event="editControllerMethodMemo"  class="admin-hand layui-icon layui-icon-edit admin-color-green admin-text-bold " title="修改功能说明"  ></i>
                        {{=method.name }}
                        ({{=method.url }})
                        <i event="sortControllerMethodUp" class="admin-hand layui-icon layui-icon-up admin-color-green"  style="font-weight: bolder;"  ></i>
                        <i event="sortControllerMethodDown" class="admin-hand layui-icon layui-icon-down admin-color-green" style="font-weight: bolder;"   ></i>
                        {{# if(!method.sysHas) { }}
                            <i class="layui-icon layui-icon-about admin-color-red admin-text-bold " title="数据库有存储，但系统中已经没有了！"   ></i>
                            <i event="delControllerMethod" class="admin-hand layui-icon layui-icon-close-fill admin-color-yellow admin-text-bold " title="删除"  ></i>
                        {{# } }}

                    </li>
                {{# }); }}
                </ul>
            </li>
        {{# }); }}
        </ul>
    </script>
    <script>
        app.use(['ajax', 'laytpl', 'jquery', 'form', 'layer', 'app_util'], function () {
            var ajax = layui.ajax;
            var laytpl = layui.laytpl;
            var $ = layui.jquery;
            var form = layui.form;
            var layer = layui.layer;
            var app_util = layui.app_util;

            var template = rightTmp.innerHTML;

            ajax.post_json('sysRight/getClassMethod', null, function(d){
                console.log(d);
                laytpl(template).render(d.result.data, function(html){
                    $('#right').html(html);
                    form.render();
                    $('i').on('click',function(){
                        var event = $(this).attr('event');
                        var data = null;
                        var t = this.parentNode.dataObj;
                        var $p = $(this).parent();
                        if( t === undefined ) {
                            data = this.parentNode.dataObj = $.parseJSON($(this).parent().attr('data'));
                        }else {
                            data = t;
                        }
                        if(event === 'editControllerMemo'){
                            layer.prompt({
                                formType: 0,
                                value: data.memo,
                                title: '功能说明'
                            }, function(value, index, elem){
                                data.memo = value;
                                ajax.post_json('sysRight/setController',{id : data.id, memo: data.memo},
                                    function(d){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        $p.find('#memo').text('[' + data.memo + ']');
                                        layer.close(index);
                                    });
                            });
                        }
                        if(event === 'editControllerMatchUrl'){
                            layer.prompt({
                                formType: 0,
                                value: data.matchUrl,
                                title: '匹配路径'
                            }, function(value, index, elem){
                                data.matchUrl = value;
                                ajax.post_json('sysRight/setController',{id : data.id, matchUrl: data.matchUrl},
                                    function(d){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        $p.find('#matchUrl').text('{' + data.matchUrl + '}');
                                        layer.close(index);
                                    });
                            });
                        }
                        if(event === 'sortControllerUp'){
                            if($p.prev().length >0 ) {
                                ajax.post_json('sysRight/changeControllerSort',{id: data.id, changeSort: -1},
                                    function(d){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        $p.prev().before($p);
                                    });
                            }

                        }
                        if(event === 'sortControllerDown'){
                            if($p.next().length > 0){
                                ajax.post_json('sysRight/changeControllerSort',{id: data.id, changeSort: 1},
                                    function(d){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        $p.next().after($p);
                                    });
                            }
                        }
                        if(event === 'delController'){
                            layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
                                ajax.post_json('sysRight/delController', {id: data.id},
                                    function(){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        layer.msg('删除完成');
                                        $p.remove();
                                    });

                                layer.close(index);
                            });
                        }
                        if(event === 'editControllerMethodMemo'){
                            layer.prompt({
                                formType: 0,
                                value: data.memo,
                                title: '功能说明'
                            }, function(value, index, elem){
                                data.memo = value;
                                ajax.post_json('sysRight/setControllerMethod',{id : data.id, memo: data.memo},
                                    function(d){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        $p.find('#methodMemo').text('[' + data.memo + ']');
                                        layer.close(index);
                                    });
                            });
                        }
                        if(event === 'sortControllerMethodUp'){
                            if($p.prev().length >0 ) {
                                ajax.post_json('sysRight/changeControllerMethodSort',{id: data.id, changeSort: -1},
                                    function(d){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        $p.prev().before($p);
                                    });
                            }
                        }
                        if(event === 'sortControllerMethodDown'){
                            if($p.next().length > 0){
                                ajax.post_json('sysRight/changeControllerMethodSort',{id: data.id, changeSort: 1},
                                    function(d){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        $p.next().after($p);
                                    });
                            }
                        }
                        if(event === 'delControllerMethod'){
                            layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
                                ajax.post_json('sysRight/delControllerMethod', {id: data.id},
                                    function(){
                                        var msg = app_util.getErrorMsg(d);
                                        if( msg != null){
                                            layer.msg(msg);
                                            return ;
                                        }
                                        layer.msg('删除完成');
                                        $p.remove();
                                    });

                                layer.close(index);
                            });
                        }
                        if(event === 'modelController'){
                            var m = '';
                            if(data.model === 'EVERYONE')
                                m = 'ASSIGN';
                            if(data.model === 'ASSIGN')
                                m = 'EVERYONE';

                            ajax.post_json('sysRight/setController',{id : data.id, model: m},
                                function(d){
                                    var msg = app_util.getErrorMsg(d);
                                    if( msg != null){
                                        layer.msg(msg);
                                        return ;
                                    }
                                    $p.find('#model').removeClass('layui-icon-group');
                                    $p.find('#model').removeClass('layui-icon-friends');
                                    if(m === 'EVERYONE') {
                                        $p.find('#model').addClass('layui-icon-group');
                                        $p.find('#model').attr('title', '本域内的所有人都可访问');
                                    }
                                    if(m === 'ASSIGN') {
                                        $p.find('#model').addClass('layui-icon-friends');
                                        $p.find('#model').attr('title', '本域内的指定人可访问');
                                    }
                                    data.model = m;
                                    layer.close(index);
                                });
                        }
                        if(event === 'editControllerDomain'){
                            ajax.post_json("sysRight/getDomain", null, function(d){
                                var msg = app_util.getErrorMsg(d);
                                if( msg != null){
                                    layer.msg(msg);
                                    return ;
                                }
                                var getDisplayByName = function(tmp, name){
                                    var r;
                                   layui.each(tmp, function(index, item){
                                       if(item.name === name)
                                           r = item.displayName;
                                   });
                                   return r;
                                };
                                layer.prompt({
                                    formType: 0,
                                    value: data.domain,
                                    title: '区域'
                                    }, function(value, index, elem) {
                                        ajax.post_json('sysRight/setController',{id : data.id, domain: value},
                                            function(dd){
                                                var msg = app_util.getErrorMsg(dd);
                                                if( msg != null){
                                                    layer.msg(msg);
                                                    return ;
                                                }
                                                data.domain = value;
                                                $p.find('#domain').text('[' + getDisplayByName(d.result.data , data.domain) + ']');
                                                layer.close(index);
                                            });

                                });
                                var pp = $('.layui-layer-input').parent();
                                $('.layui-layer-input').hide();
                                var s = $('<select></select>');
                                s.addClass('layui-layer-input');
                                s.change(function(){
                                    $('.layui-layer-input').val(s.val());
                                });

                                layui.each(d.result.data, function(index,item){
                                    //var o = $('<option/>');
                                    var o = document.createElement("option");
                                    o.value = item.name;
                                    o.innerHTML = item.displayName;
                                    if(data.domain === item.name)
                                        o.selected = true;
                                    s.append(o);
                                });
                                if(data.domain != null && data.domain !== '') {
                                    $('.layui-layer-input').val(data.domain);
                                    s.val(data.domain);
                                }else{
                                    $('.layui-layer-input').val(s.val());
                                }
                                pp.append(s);
                            });
                        }

                    });
                });
            });

        });
    </script>
</#macro>