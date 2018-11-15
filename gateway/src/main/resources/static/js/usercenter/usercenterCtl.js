angular.module('usercenter', ['headerMode']).controller('usercenterCtl', ['$scope', '$http', function($scope, $http){

    $scope.now='个人中心';

    $http.get('/me').then(function(data){
        console.log(data.data);
        $scope.user=data.data;
    });
/*
    $scope.name = "Admin";
    $scope.number = "0001";
    $scope.idCard = "12345678998754321";
    $scope.email = "1210754789@qq.com";
    $scope.phone = "18129934135";
    $scope.provice = "陕西省";
    $scope.city = "榆林市";
    $scope.county = "府谷县";
    $scope.proviceAddress = "广东省";
    $scope.cityAddress = "深圳市";
    $scope.countyAddress = "龙岗区";
    $scope.detailAddress = "坂田街道";*/

}]);

$(function(){
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#imageHead'
            , url: '/upload/'
            , done: function (res) {
                console.log(res)
            }
        });
    });
});



