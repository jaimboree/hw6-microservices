angular.module('items', ['ngRoute']).config(function ($routeProvider) {

    $routeProvider.when('/', {
        templateUrl: 'items.html',
        controller: 'items'
    })

}).controller('items', function ($scope, $http) {

    $http.get('random').success(function (data) {
        $scope.fortune = data;
    });

});