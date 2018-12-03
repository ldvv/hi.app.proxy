var headerMode = angular.module('headerMode', []);

headerMode.controller("headerCtrl", ['$rootScope', function($rootScope){
    $rootScope.now='人事管理';

    $rootScope.notice='我是公告！！！！！！！！！！！';

    $rootScope.me='Admin';

}]);

/*headerMode.run(function(){
    layui.use('element', function(){
        var element = layui.element;

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
});*/

$().ready(function(e) {
    layui.use('element', function(){
        var element = layui.element;

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
});
