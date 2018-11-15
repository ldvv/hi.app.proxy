var headerMode = angular.module('headerMode', []);

headerMode.controller("headerCtrl", ['$rootScope', function($rootScope){
    $rootScope.now='人事管理';

    $rootScope.notice='aaaaaaasdasssssssssssssss';

    $rootScope.me='Admin';

}]);

$(function(){
    layui.use('element', function(){
        var element = layui.element;

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
});