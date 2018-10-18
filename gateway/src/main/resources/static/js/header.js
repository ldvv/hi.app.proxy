var headerMode = angular.module('headerMode', []);

headerMode.controller("headerCtrl", ['$rootScope', function($rootScope){
    $rootScope.notice='aaaaaaasdasssssssssssssss';

    $rootScope.now='人事管理';


}]);

layui.use('element', function(){
    var $ = layui.jquery,
        element = layui.element;

    //监听导航点击
    element.on('nav(demo)', function(elem){
        //console.log(elem)
        layer.msg(elem.text());
    });
});