app = angular.module('admin-app',['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/product",{
        templateUrl:"/assets/admin/product/index.html",
        controller:"product-ctrl"
    })
    .when("/authorize",{
        templateUrl:"/assets/admin/authority/index.html",
        controller:"authority-ctrl"
    })
    .when("/unauthorized",{
        templateUrl:"/assets/admin/authority/unauthorized.html",
        controller:"unauthority-ctrl"
    })
    .otherwise({
        tempplate: "<h1>FPT</h1>"
    })
})